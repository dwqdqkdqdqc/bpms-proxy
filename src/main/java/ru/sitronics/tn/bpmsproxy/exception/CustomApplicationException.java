package ru.sitronics.tn.bpmsproxy.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.Collections;
import java.util.List;

/*
https://github.com/SeunMatt/smattme-tutorials/blob/master/spring-boot-exception-handling/src/main/java/com/smattme/springbootexceptionhandling/CustomApplicationException.java
 */

public class CustomApplicationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;
    private List<String> errors;
    private Object data;

    public CustomApplicationException(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    public CustomApplicationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CustomApplicationException(HttpStatus httpStatus, String message) {
        this(httpStatus, message, Collections.singletonList(message), null);
    }

    public CustomApplicationException(HttpStatus httpStatus, String message, Object data) {
        this(httpStatus, message, Collections.singletonList(message), data);
    }

    public CustomApplicationException(HttpStatus httpStatus, String message, List<String> errors) {
        this(httpStatus, message, errors, null);
    }

    public CustomApplicationException(HttpStatus httpStatus, String message, List<String> errors, Object data) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public List<String> getErrors() {
        return errors;
    }

    public Object getData() {
        return data;
    }
}
