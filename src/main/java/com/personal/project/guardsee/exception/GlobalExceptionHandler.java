package com.personal.project.guardsee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedProductPropException.class)
    public ResponseEntity<?> handleDuplicatedProductPropException(DuplicatedProductPropException ex) {
        var response = new HashMap<String, Object>();
        response.put("error", "Já existe um produto com este número de série.");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
