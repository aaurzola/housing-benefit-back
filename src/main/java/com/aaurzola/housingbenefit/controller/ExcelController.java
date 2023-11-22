package com.aaurzola.housingbenefit.controller;

import com.aaurzola.housingbenefit.dto.ReportDTO;
import com.aaurzola.housingbenefit.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "reports")
public class ExcelController {

    private final ReportService reportService;

    @Autowired
    public ExcelController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> downloadExcel(@RequestBody ReportDTO reportDTO) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).headers(configureHeaders()).body(reportService.createExcelWorkbook(reportDTO));
    }

    private static HttpHeaders configureHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentDispositionFormData("attachment", "reporte.xlsx");
        return headers;
    }
}
