package com.aaurzola.housingbenefit.exception;

public class RejectException extends RuntimeException {

    public RejectException() {
        super("Ha ocurrido un problema al tratar de rechazar la solicitud");
    }
}
