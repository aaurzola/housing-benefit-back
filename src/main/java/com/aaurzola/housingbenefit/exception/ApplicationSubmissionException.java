package com.aaurzola.housingbenefit.exception;

public class ApplicationSubmissionException extends RuntimeException {

    public ApplicationSubmissionException() {
        super("Aplicación no pudo ser procesada. Intente nuevamente");
    }
}
