package com.aaurzola.housingbenefit.service.request;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.RequestDTO;
import com.aaurzola.housingbenefit.exception.RequestSubmissionException;
import com.aaurzola.housingbenefit.exception.ResourceNotFoundException;
import com.aaurzola.housingbenefit.model.Request;
import com.aaurzola.housingbenefit.repository.RequestRepository;
import com.aaurzola.housingbenefit.repository.RequestorJDBC;
import com.aaurzola.housingbenefit.validation.IndividualValidator;
import com.aaurzola.housingbenefit.validation.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImp implements RequestService {

    private final RequestRepository repository;
    private final RequestorJDBC requestorJDBC;
    private final IndividualValidator individualValidator;
    private final RequestValidator requestValidator;

    @Autowired
    public RequestServiceImp(RequestRepository repository, RequestorJDBC requestorJDBC, IndividualValidator individualValidator, RequestValidator requestValidator) {
        this.repository = repository;
        this.requestorJDBC = requestorJDBC;
        this.individualValidator = individualValidator;
        this.requestValidator = requestValidator;
    }

    @Override
    public List<Request> getAllRequests() {
        return repository.findAllRequests();
    }

    @Override
    public Request getRequestById(Long requestId) {
        return repository.findById(requestId).orElseThrow(() -> new ResourceNotFoundException("Solicitud", requestId));
    }

    @Override
    public Long submitRequest(RequestDTO requestDTO) {
        individualValidator.assertRequestersNotEmpty(requestDTO.getRequesters());
        for (Long individualId : requestDTO.getRequesters()) {
            individualValidator.assertIndividualExists(individualId);
        }
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
        requestValidator.assertRequestIdExists(requestId);
        return repository.findRequesterByRequestId(requestId);
    }

}
