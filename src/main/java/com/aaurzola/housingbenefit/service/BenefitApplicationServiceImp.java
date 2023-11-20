package com.aaurzola.housingbenefit.service;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.ApplicationRequestDTO;
import com.aaurzola.housingbenefit.exception.ApplicationSubmissionException;
import com.aaurzola.housingbenefit.model.BenefitApplication;
import com.aaurzola.housingbenefit.repository.BenefitApplicationRepository;
import com.aaurzola.housingbenefit.repository.RequestorJDBC;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitApplicationServiceImp implements BenefitApplicationService{

    private final BenefitApplicationRepository repository;
    private final RequestorJDBC requestorJDBC;

    @Autowired
    public BenefitApplicationServiceImp(BenefitApplicationRepository repository, RequestorJDBC requestorJDBC) {
        this.repository = repository;
        this.requestorJDBC = requestorJDBC;
    }

    @Override
    public List<BenefitApplication> getAllApplications() {
        return repository.findAllApplications();
    }

    @Override
    public BenefitApplication getBenefitApplicationById(Long applicationId) {
        return repository.findById(applicationId).orElse(null);
    }

    @Override
    @Transactional
    public Long submitApplication(ApplicationRequestDTO applicationRequest) {
        //validate person id
        try {
            BenefitApplication savedRequest = repository.save(applicationRequest.getApplication());
            requestorJDBC.assignIndividualToRequest(savedRequest.getId(), applicationRequest.getRequesters());
            repository.isRequestViable(savedRequest.getId());
            repository.assignBenefitToRequest(savedRequest.getId());
            return savedRequest.getId();
        } catch (Exception e) {
            throw new ApplicationSubmissionException();
        }
    }

    @Override
    public List<RequesterDetailDTO> getApplicationRequester(Long applicationId) {
        return repository.findRequesterByApplicationId(applicationId);
    }

}
