package ru.sitronics.tn.camundaproxyrestapi.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
https://github.com/SeunMatt/smattme-tutorials/blob/master/spring-boot-exception-handling/src/main/java/com/smattme/springbootexceptionhandling/GlobalExceptionHandler.java
 */

@RestController
@RestControllerAdvice
public class GlobalExceptionHandler implements ErrorController {

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler(CustomApplicationException.class)
    public ResponseEntity<Map<String, Object>> handleError(CustomApplicationException e, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("code", e.getHttpStatus().value());
        response.put("message", getErrorMessage(request, e.getHttpStatus()));
        response.put("errors", e.getErrors());
        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleError(HttpRequestMethodNotSupportedException e) {
        String message = e.getMessage();
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;

        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("code", status.value());
        response.put("message", "It seems you're using the wrong HTTP method");
        response.put("errors", Collections.singletonList(message));
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleError(Exception e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("code", httpStatus.value());
        response.put("message", "Error occured");
        response.put("errors", e.getLocalizedMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }

    private String getErrorMessage(HttpServletRequest request, HttpStatus httpStatus) {

        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        if (message != null && !message.isEmpty()) {
            return message;
        }

        message = switch (httpStatus) {
            case NOT_FOUND -> "The resource does not exist";
            case INTERNAL_SERVER_ERROR -> "Something went wrong internally";
            case FORBIDDEN -> "Permission denied";
            case TOO_MANY_REQUESTS -> "Too many requests";
            default -> httpStatus.getReasonPhrase();
        };

        return message;
    }
}