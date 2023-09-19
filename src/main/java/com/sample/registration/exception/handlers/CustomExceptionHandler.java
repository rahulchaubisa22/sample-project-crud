package com.sample.registration.exception.handlers;
import com.sample.registration.error.CustomErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({HttpStatusCodeException.class})
    public ResponseEntity<Object> handleAllExceptions(HttpStatusCodeException ex) {
        // Create a custom error response format
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                "Internal Server Error",
                "This is sample Error"
        );

        return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
    }
}