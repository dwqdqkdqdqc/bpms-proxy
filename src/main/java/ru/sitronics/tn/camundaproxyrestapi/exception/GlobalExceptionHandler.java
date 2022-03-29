package ru.sitronics.tn.camundaproxyrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ HttpClientErrorException.NotFound.class })
    public ResponseEntity<Object> handleHttpClientErrorException(
            HttpClientErrorException ex,
            WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                ex.getStatusText(),
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(
            Exception ex,
            WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "Error occurred" ,
                details);

        return ResponseEntityBuilder.build(err);
    }
}