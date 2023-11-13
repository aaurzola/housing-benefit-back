package com.aaurzola.housingbenefit.repository;

import com.aaurzola.housingbenefit.dto.applicationRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class RequestorJDBC {
    @Value("${spring.datasource.url}")
    private String databasebUrl;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;


    public void assignIndividualToRequest(applicationRequestDTO applicationRequest) {
        try(Connection conn = DriverManager.getConnection(databasebUrl, user, password)) {
            for (Long personId: applicationRequest.getRequesters()) {
                CallableStatement stmt = conn.prepareCall("CALL APP_SUBSIDIOS_VIVIENDA.HOUSING_SUBSIDY.ASSIGN_REQUESTER(?, ?)");
                stmt.setLong(1, personId);
                stmt.setLong(2, applicationRequest.getApplication().getId());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
