package com.aaurzola.housingbenefit.repository;

import com.aaurzola.housingbenefit.model.BenefitApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitApplicationRepository extends JpaRepository<BenefitApplication, Long> {

    @Query(value = "SELECT b FROM BenefitApplication b")
    List<BenefitApplication> findAllApplications();

    @Procedure("HOUSING_SUBSIDY.SUBMIT_BENEFIT_REQUEST")
    void submitBenefitRequest(Long benefitApplicationId);
}
