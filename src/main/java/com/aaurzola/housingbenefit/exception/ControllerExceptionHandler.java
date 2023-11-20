package com.aaurzola.housingbenefit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RequestSubmissionException.class)
    public ResponseEntity<String> ApplicationSubmissionException(RequestSubmissionException ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());

    }



}
