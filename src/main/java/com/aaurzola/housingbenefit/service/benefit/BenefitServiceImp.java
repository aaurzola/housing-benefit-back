package com.aaurzola.housingbenefit.service.benefit;

import com.aaurzola.housingbenefit.model.Benefit;
import com.aaurzola.housingbenefit.repository.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitServiceImp implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Autowired
    public BenefitServiceImp(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    @Override
    public List<Benefit> findBenefitDetails(Long requestId) {
        //validate requestId

        return benefitRepository.findAllByBenefitApplicationId(requestId);
    }
}
