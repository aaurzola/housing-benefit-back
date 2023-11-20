package com.aaurzola.housingbenefit.validation;


import com.aaurzola.housingbenefit.repository.BenefitApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {
    private final BenefitApplicationRepository benefitApplicationRepository;

    @Autowired
    public RequestValidator(BenefitApplicationRepository benefitApplicationRepository) {
        this.benefitApplicationRepository = benefitApplicationRepository;
    }

    public Boolean existsRequestId(Long requestId) {
        return benefitApplicationRepository.existsById(requestId);
    }
}
