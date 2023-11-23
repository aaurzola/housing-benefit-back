package com.aaurzola.housingbenefit.service.report;

import com.aaurzola.housingbenefit.dto.ReportDTO;
import com.aaurzola.housingbenefit.model.Request;
import com.aaurzola.housingbenefit.repository.RequestRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportServiceImp implements ReportService {

    private final RequestRepository requestRepository;

    @Autowired
    public ReportServiceImp(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public byte[] createExcelWorkbook(ReportDTO reportParams) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("reporte_beneficio_vivienda");

        CellStyle dateStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id_Solicitud");
        headerRow.createCell(1).setCellValue("Tipo_Vivienda");
        headerRow.createCell(2).setCellValue("Fecha_Solicitud");
        headerRow.createCell(3).setCellValue("Estado_Solicitud");

        headerRow.getCell(2).setCellStyle(dateStyle);

        int rowNum = 1;
        List<Request> data = requestRepository.
                findAllByHousingTypeAndCreatedAtBetween(
                        reportParams.getHousingType(),
                        reportParams.getReportStartDate(),
                        reportParams.getReportEndDate()
        );

        for (Request entity : data) {
            Row dataRow = sheet.createRow(rowNum++);
            dataRow.createCell(0).setCellValue(entity.getId());
            dataRow.createCell(1).setCellValue(entity.getHousingType());

            Cell dateCell = dataRow.createCell(2);
            dateCell.setCellValue(entity.getCreatedAt());
            dateCell.setCellStyle(dateStyle);

            dataRow.createCell(3).setCellValue(entity.getIsApproved().toString());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}
