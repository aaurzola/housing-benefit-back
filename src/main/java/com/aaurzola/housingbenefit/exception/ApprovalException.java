package com.aaurzola.housingbenefit.exception;

public class ApprovalException extends RuntimeException {

    public ApprovalException() {
        super("Ha ocurrido un problema al tratar de aprobar la solicitud");
    }
}
