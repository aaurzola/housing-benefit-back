package com.aaurzola.housingbenefit.repository;

import com.aaurzola.housingbenefit.model.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {
    List<Benefit> findAllByBenefitApplicationId(Long requestId);

}
