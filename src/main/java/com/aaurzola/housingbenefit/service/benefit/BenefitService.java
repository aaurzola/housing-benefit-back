package com.aaurzola.housingbenefit.service.benefit;

import com.aaurzola.housingbenefit.model.Benefit;

import java.util.List;

public interface BenefitService {

    /**
     * finds all the details associated to a request
     * @param requestId
     * @return a list of entity 'Benefit'
     */
    List<Benefit> findBenefitDetails(Long requestId);
}
