package ru.sitronics.tn.camundaproxyrestapi.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
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
        response.put("message", e.getMessage());
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

    @RequestMapping(value = "/error", produces = "application/json")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        HttpStatus httpStatus = getHttpStatus(request);
        String message = getErrorMessage(request, httpStatus);

        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("code", httpStatus.value());
        response.put("message", message);
        response.put("errors", Collections.singletonList(message));

        return ResponseEntity.status(httpStatus).body(response);
    }

    private HttpStatus getHttpStatus(HttpServletRequest request) {

        //get the standard error code set by Spring Context
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            return HttpStatus.valueOf(status);
        }

        // maybe we're the one that trigger the redirect
        // with the code param
        String code = request.getParameter("code");
        if (code != null && !code.isBlank()) {
            return HttpStatus.valueOf(code);
        }

        //default fallback
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleError(Exception e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("code", httpStatus.value());
        response.put("message", "Error occured");
        //TODO Make clear error message
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