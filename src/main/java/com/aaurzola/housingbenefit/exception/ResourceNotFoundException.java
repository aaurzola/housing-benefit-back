package com.aaurzola.housingbenefit.exception;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String entity, Object identifier) {
        super(entity + " con id '" + String.valueOf(identifier) + "' no existe.");
    }

}
