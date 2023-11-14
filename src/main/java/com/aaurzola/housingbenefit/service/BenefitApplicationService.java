package com.aaurzola.housingbenefit.service;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.applicationRequestDTO;
import com.aaurzola.housingbenefit.model.BenefitApplication;

import java.util.List;

public interface BenefitApplicationService {

    List<BenefitApplication> getAllApplications();
    BenefitApplication getBenefitApplicationById(Long applicationId);
    BenefitApplication SubmitApplication(applicationRequestDTO application);
    List<RequesterDetailDTO> getApplicationRequester(Long applicationId);

}
