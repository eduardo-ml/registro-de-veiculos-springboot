package com.eduardo_ml.registro_de_veiculos.exception;

public class DataIntegrityViolation extends RuntimeException {
    public DataIntegrityViolation(String message) {
        super(message);
    }
}
