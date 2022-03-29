package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sitronics.tn.camundaproxyrestapi.dto.ProcessInstanceDto;

@Service
@Slf4j
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {

    @Value("${camunda.uri}")
    private String camundaUri;
    private final RestTemplate restTemplate;

    @Autowired
    public ProcessDefinitionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProcessInstanceDto startProcess(String key) {
        String endPointUri = "/process-definition/key/%s/start";
        String url = String.format(camundaUri + endPointUri, key);
        String requestJson = "{}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        log.info(url);
        return this.restTemplate.postForObject(url, entity, ProcessInstanceDto.class);
    }
}
