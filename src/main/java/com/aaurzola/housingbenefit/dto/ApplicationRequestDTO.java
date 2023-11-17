package com.aaurzola.housingbenefit.dto;

import com.aaurzola.housingbenefit.model.BenefitApplication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationRequestDTO {
    private BenefitApplication application;
    private List<Long> requesters;
}
