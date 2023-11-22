package com.aaurzola.housingbenefit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    private String housingType;
    private Date reportStartDate;
    private Date reportEndDate;
}
