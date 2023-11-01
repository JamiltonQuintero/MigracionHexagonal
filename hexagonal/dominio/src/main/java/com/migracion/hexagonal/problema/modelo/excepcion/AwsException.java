package com.migracion.hexagonal.problema.modelo.excepcion;

public class AwsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AwsException(String message) {
        super(message);
    }

}
