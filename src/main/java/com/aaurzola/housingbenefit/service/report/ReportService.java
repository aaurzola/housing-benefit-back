package com.aaurzola.housingbenefit.service.report;

import com.aaurzola.housingbenefit.dto.ReportDTO;

import java.io.IOException;


public interface ReportService {

    /**
     * creates an Excel file with the information of a query result set from the 'Request' entity
     * @param reportParams
     * @return a downloadable file that contains the informacion of an .xlsx file
     * @throws IOException
     */
    byte[] createExcelWorkbook(ReportDTO reportParams) throws IOException;
}
