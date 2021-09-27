package com.mkdev.weatherlady.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(final NotFoundException notFoundException) {
            return notFoundException.getMessage();
    }

}
