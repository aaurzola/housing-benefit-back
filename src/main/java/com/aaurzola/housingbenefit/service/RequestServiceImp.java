package com.aaurzola.housingbenefit.service;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.RequestDTO;
import com.aaurzola.housingbenefit.exception.RequestSubmissionException;
import com.aaurzola.housingbenefit.model.Request;
import com.aaurzola.housingbenefit.repository.RequestRepository;
import com.aaurzola.housingbenefit.repository.RequestorJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImp implements RequestService {

    private final RequestRepository repository;
    private final RequestorJDBC requestorJDBC;

    @Autowired
    public RequestServiceImp(RequestRepository repository, RequestorJDBC requestorJDBC) {
        this.repository = repository;
        this.requestorJDBC = requestorJDBC;
    }

    @Override
    public List<Request> getAllRequests() {
        return repository.findAllRequests();
    }

    @Override
    public Request getRequestById(Long requestId) {
        return repository.findById(requestId).orElse(null);
    }

    @Override
    public Long submitRequest(RequestDTO requestDTO) {
        //validate person id
        try {
            Request savedRequest = repository.save(requestDTO.getApplication());
            requestorJDBC.assignIndividualToRequest(savedRequest.getId(), requestDTO.getRequesters());
            repository.isRequestViable(savedRequest.getId());
            repository.assignBenefitToRequest(savedRequest.getId());
            return savedRequest.getId();
        } catch (Exception e) {
            throw new RequestSubmissionException();
        }
    }

    @Override
    public List<RequesterDetailDTO> getRequester(Long requestId) {
        return repository.findRequesterByRequestId(requestId);
    }

}
