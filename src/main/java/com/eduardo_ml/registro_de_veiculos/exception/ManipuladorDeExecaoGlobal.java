package com.eduardo_ml.registro_de_veiculos.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManipuladorDeExecaoGlobal {

    private static final Logger logger = LoggerFactory.getLogger(ManipuladorDeExecaoGlobal.class);

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> manipuladorNaoEncontrado(ResourceNotFound ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception ex) {
        logger.error("Ocorreu um erro interno não esperado.", ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocorreu um erro interno no servidor.");
    }

    @ExceptionHandler(DataIntegrityViolation.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolation ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Erro de integridade de dados. A placa informada já pode existir no sistema.");
    }
}
