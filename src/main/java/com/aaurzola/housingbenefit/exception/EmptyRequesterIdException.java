package com.aaurzola.housingbenefit.exception;

public class EmptyRequesterIdException extends RuntimeException {

    public EmptyRequesterIdException() {
        super("La lista de solicitantes no puede estar vacía");
    }
}
