package com.aaurzola.housingbenefit.validation;


import com.aaurzola.housingbenefit.exception.ResourceNotFoundException;
import com.aaurzola.housingbenefit.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestValidator(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void assertRequestIdExists(Long requestId) {
        if (!requestRepository.existsById(requestId)) {
            throw new ResourceNotFoundException("Solicitud", requestId);
        }
    }
}
