package com.aaurzola.housingbenefit.service.report;

import com.aaurzola.housingbenefit.dto.ReportDTO;

import java.io.IOException;


public interface ReportService {
    byte[] createExcelWorkbook(ReportDTO reportParams) throws IOException;
}
