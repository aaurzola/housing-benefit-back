package com.aaurzola.housingbenefit.repository;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "SELECT r FROM Request r ORDER BY r.createdAt DESC")
    List<Request> findAllRequests();

    @Query(value = "SELECT i.ID AS \"id\", i.FIRST_NAME AS \"firstName\", i.LAST_NAME AS \"lastName\", i.EMAIL AS \"email\", i.PHONE_NUMBER AS \"phoneNumber\",\n" +
            "\t\ti.IS_PROPERTY_OWNER AS \"isPropertyOwner\", i.HAS_HOUSING_SUBSIDY_FUND AS \"hasHousingSubsidyFund\", i.HAS_HOUSING_SUBSIDY_GOV AS \"hasHousingSubsidyGov\",i.HAS_INTEREST_SUBSIDY AS \"hasInterestSubsidy\"\n" +
            "FROM (APP_SUBSIDIOS_VIVIENDA.BENEFIT_REQUESTOR br\n" +
            "JOIN APP_SUBSIDIOS_VIVIENDA.INDIVIDUAL i \n" +
            "ON i.ID =br.INDIVIDUAL_ID)\n" +
            "WHERE br.BENEFIT_APPLICATION_ID =:requestId", nativeQuery = true)
    List<RequesterDetailDTO> findRequesterByRequestId(@Param("requestId") Long requestId);

    List<Request> findAllByHousingTypeAndCreatedAtBetween(String housingType, Date createdAtStart, Date createdAtEnd);

    @Procedure("HOUSING_SUBSIDY.IS_REQUEST_VIABLE")
    void isRequestViable(Long requestId);

    @Procedure("HOUSING_SUBSIDY.ASSIGN_BENEFIT_TO_REQUEST")
    void assignBenefitToRequest(Long requestId);

    @Procedure("HOUSING_SUBSIDY.APPROVE_REQUEST")
    void approveRequest(Long requestId);

    @Procedure("HOUSING_SUBSIDY.REJECT_REQUEST")
    void rejectRequest(Long requestId);

    @Procedure("HOUSING_SUBSIDY.DELETE_REJECTED_REQUEST")
    void deleteAllRejectedRequest();
}
