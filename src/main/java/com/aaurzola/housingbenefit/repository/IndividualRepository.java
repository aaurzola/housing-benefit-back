package com.aaurzola.housingbenefit.repository;

import com.aaurzola.housingbenefit.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {
}
