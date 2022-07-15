package com.tp.clinicaodontologica.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> errorNotFound(ResourceNotFoundException exc){
        log.error(exc.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exc.getMessage());
    }

    @ExceptionHandler({InvalidDataResource.class})
    public ResponseEntity<String> errorBadReques( Exception exc){
        log.error(exc.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
    }
}
