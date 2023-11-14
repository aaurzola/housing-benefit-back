package com.aaurzola.housingbenefit.repository;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.model.BenefitApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitApplicationRepository extends JpaRepository<BenefitApplication, Long> {

    @Query(value = "SELECT b FROM BenefitApplication b")
    List<BenefitApplication> findAllApplications();

    @Procedure("HOUSING_SUBSIDY.SUBMIT_BENEFIT_REQUEST")
    void submitBenefitRequest(Long benefitApplicationId);


    @Query(value = "SELECT i.ID AS \"id\", i.FIRST_NAME AS \"firstName\", i.LAST_NAME AS \"lastName\", i.EMAIL AS \"email\", i.PHONE_NUMBER AS \"phoneNumber\",\n" +
            "\t\ti.IS_PROPERTY_OWNER AS \"isPropertyOwner\", i.HAS_HOUSING_SUBSIDY_FUND AS \"hasHousingSubsidyFund\", i.HAS_HOUSING_SUBSIDY_GOV AS \"hasHousingSubsidyGov\",i.HAS_INTEREST_SUBSIDY AS \"hasInterestSubsidy\"\n" +
            "FROM (APP_SUBSIDIOS_VIVIENDA.BENEFIT_REQUESTOR br\n" +
            "JOIN APP_SUBSIDIOS_VIVIENDA.INDIVIDUAL i \n" +
            "ON i.ID =br.INDIVIDUAL_ID)\n" +
            "WHERE br.BENEFIT_APPLICATION_ID =:applicationId", nativeQuery = true)
    List<RequesterDetailDTO> findRequesterByApplicationId(@Param("applicationId") Long applicationId);
}
