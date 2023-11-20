package com.aaurzola.housingbenefit.service.benefit;

import com.aaurzola.housingbenefit.model.Benefit;

import java.util.List;

public interface BenefitService {

    List<Benefit> findBenefitDetails(Long requestId);
}
