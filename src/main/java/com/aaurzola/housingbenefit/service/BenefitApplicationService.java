package com.aaurzola.housingbenefit.service;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.ApplicationRequestDTO;
import com.aaurzola.housingbenefit.model.BenefitApplication;

import java.util.List;

public interface BenefitApplicationService {

    List<BenefitApplication> getAllApplications();
    BenefitApplication getBenefitApplicationById(Long applicationId);
    BenefitApplication submitApplication(ApplicationRequestDTO application);
    List<RequesterDetailDTO> getApplicationRequester(Long applicationId);

}
