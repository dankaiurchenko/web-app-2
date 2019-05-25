package com.danarossa.webapp2.config;


import com.danarossa.webapp2.service.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleConstraintViolation(ServiceException ex, WebRequest request) {
        return new ResponseEntity<>(
                ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
