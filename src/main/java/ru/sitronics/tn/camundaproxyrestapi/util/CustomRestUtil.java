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
import ru.sitronics.tn.camundaproxyrestapi.dto.CamundaApiErrorMessage;
import ru.sitronics.tn.camundaproxyrestapi.exception.CustomApplicationException;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomRestUtil {

    @Value("${camunda.uri}")
    private String camundaUri;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public <T> T get(String endPointUri, Class<T> type) {

        try {
            String url = camundaUri + endPointUri;
            log.info(url);
            return this.restTemplate.getForObject(url, type);

        } catch (HttpStatusCodeException e) {
            throw catchException(e);
        }
    }

    public <T> T post(String endPointUri, String requestBody, Class<T> type) {

        try {
            String url = camundaUri + endPointUri;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
            log.info("URL: " + url + ", Request body: " + requestBody);
            return this.restTemplate.postForObject(url, entity, type);

        } catch (HttpStatusCodeException e) {
           throw catchException(e);
        }
    }

    private CustomApplicationException catchException(HttpStatusCodeException e) {
        CamundaApiErrorMessage camundaApiErrorMessage;
        try {
            camundaApiErrorMessage = objectMapper.readValue(e.getResponseBodyAsString(), CamundaApiErrorMessage.class);
        } catch (JsonProcessingException e1) {
            log.error(e1.toString());
            throw new CustomApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, e1.getMessage());
        }
        log.error(e.toString());
        throw new CustomApplicationException(e.getStatusCode(), camundaApiErrorMessage.getMessage());
    }
}
