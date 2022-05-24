package ru.sitronics.tn.camundaproxyrestapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import ru.sitronics.tn.camundaproxyrestapi.dto.CamundaApiExceptionDto;
import ru.sitronics.tn.camundaproxyrestapi.exception.CustomApplicationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomRestClient {

    @Value("${camunda.uri}")
    private String camundaUri;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public <T> List<T> getList(String endPointUri, Class<T[]> responseClass) {

        try {
            String url = camundaUri + endPointUri;
            T[] array = restTemplate.getForObject(url, responseClass);
            log.info("URL: " + url);
            if (array == null) {
                return new ArrayList<>();
            }
            return Arrays.stream(array).toList();

        } catch (HttpStatusCodeException e) {
            throw catchException(e);
        }
    }

    public <T> T post(String endPointUri, Class<T> responseClass) {

        try {
            String url = camundaUri + endPointUri;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            log.info("URL: " + url);
            return restTemplate.postForObject(url, entity, responseClass);

        } catch (HttpStatusCodeException e) {
            throw catchException(e);
        }
    }

    public <T> T post(String endPointUri, Object requestBody, Class<T> responseClass) {

        try {
            String url = camundaUri + endPointUri;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);
            log.info("URL: " + url + ", Request body object: " + requestBody);
            return restTemplate.postForObject(url, entity, responseClass);

        } catch (HttpStatusCodeException e) {
           throw catchException(e);
        }
    }

    private CustomApplicationException catchException(HttpStatusCodeException e) {
        CamundaApiExceptionDto camundaApiExceptionDto;
        try {
            camundaApiExceptionDto = objectMapper.readValue(e.getResponseBodyAsString(), CamundaApiExceptionDto.class);
        } catch (JsonProcessingException e1) {
            log.error(e1.toString());
            throw new CustomApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, e1.getMessage());
        }
        log.error(e.toString());
        throw new CustomApplicationException(e.getStatusCode(), camundaApiExceptionDto.getMessage());
    }
}
