package com.example.demo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorDescription> handleDataNotFoundException(Exception ex, HttpServletRequest request) {
        final ErrorDescription errorDescription = new ErrorDescription();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        errorDescription.setPath(request.getRequestURI());
        errorDescription.setTimestamp(Long.valueOf(System.currentTimeMillis()).toString());
        errorDescription.setCode(String.valueOf(httpStatus.value()));
        errorDescription.setDetail(ex.getLocalizedMessage());

        return new ResponseEntity<>(errorDescription, httpStatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ErrorDescription> handleIllegalArgumentException(Exception ex, HttpServletRequest request) {
        final ErrorDescription errorDescription = new ErrorDescription();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        errorDescription.setPath(request.getRequestURI());
        errorDescription.setTimestamp(Long.valueOf(System.currentTimeMillis()).toString());
        errorDescription.setCode(String.valueOf(httpStatus.value()));
        errorDescription.setDetail(ex.getLocalizedMessage());

        return new ResponseEntity<>(errorDescription, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDescription> handleException(Exception ex, HttpServletRequest request) {
        final ErrorDescription errorDescription = new ErrorDescription();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        errorDescription.setPath(request.getRequestURI());
        errorDescription.setTimestamp(Long.valueOf(System.currentTimeMillis()).toString());
        errorDescription.setCode(String.valueOf(httpStatus.value()));
        errorDescription.setDetail(ex.getLocalizedMessage());

        return new ResponseEntity<>(errorDescription, httpStatus);
    }

}
