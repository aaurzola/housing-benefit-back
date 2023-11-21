package com.aaurzola.housingbenefit.validation;

import com.aaurzola.housingbenefit.exception.EmptyRequesterIdException;
import com.aaurzola.housingbenefit.exception.ResourceNotFoundException;
import com.aaurzola.housingbenefit.repository.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IndividualValidator {

    private final IndividualRepository repository;

    @Autowired
    public IndividualValidator(IndividualRepository repository) {
        this.repository = repository;
    }

    public void assertIndividualExists(Long individualId) {
        if (!repository.existsById(individualId)) {
            throw new ResourceNotFoundException("Ciudadano", individualId);
        }
    }

    public void assertRequestersNotEmpty(List<Long> requesters) {
        if (requesters.isEmpty()) {
            throw new EmptyRequesterIdException();
        }
    }
}
