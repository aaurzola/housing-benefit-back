package com.aaurzola.housingbenefit.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Component
public class RequestorJDBC {
    @Value("${spring.datasource.url}")
    private String databasebUrl;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;


    public void assignIndividualToRequest(Long applicationId, List<Long> requesters) {
        try (
                Connection conn = DriverManager.getConnection(databasebUrl, user, password);
                CallableStatement stmt = conn.prepareCall("CALL APP_SUBSIDIOS_VIVIENDA.HOUSING_SUBSIDY.ASSIGN_REQUESTER(?, ?)")
        ) {
            for (Long personId: requesters) {
                stmt.setLong(1, personId);
                stmt.setLong(2, applicationId);
                stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
