package com.aaurzola.housingbenefit.service.benefit;

import com.aaurzola.housingbenefit.exception.ResourceNotFoundException;
import com.aaurzola.housingbenefit.model.Benefit;
import com.aaurzola.housingbenefit.repository.BenefitRepository;
import com.aaurzola.housingbenefit.validation.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitServiceImp implements BenefitService {

    private final BenefitRepository benefitRepository;
    private final RequestValidator validator;

    @Autowired
    public BenefitServiceImp(BenefitRepository benefitRepository, RequestValidator validator) {
        this.benefitRepository = benefitRepository;
        this.validator = validator;
    }

    @Override
    public List<Benefit> findBenefitDetails(Long requestId) {
        validator.assertRequestIdExists(requestId);
        return benefitRepository.findAllByBenefitApplicationId(requestId);
    }
}
