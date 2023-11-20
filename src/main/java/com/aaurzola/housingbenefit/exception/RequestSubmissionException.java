package com.aaurzola.housingbenefit.exception;

public class RequestSubmissionException extends RuntimeException {

    public RequestSubmissionException() {
        super("Aplicación no pudo ser procesada. Intente nuevamente");
    }
}
