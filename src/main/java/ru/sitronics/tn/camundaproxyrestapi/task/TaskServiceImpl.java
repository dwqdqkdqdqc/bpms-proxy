package ru.sitronics.tn.camundaproxyrestapi.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Value("${camunda.uri}")
    private String camundaUri;
    private final RestTemplate restTemplate;

    public TaskServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<TaskDto> getTaskByAssignee(String assignee) {
        String endPointUri = "/task";
        String url = String.format(camundaUri + endPointUri + "?assignee=%s", assignee);
        log.info(url);

        //TODO Check if the Array is null

        return List.of(this.restTemplate.getForObject(url, TaskDto[].class));
    }

    @Override
    public void claimTask(String taskId, String userId) {
        String endPointUri = "/task/%s/claim";
        String url = String.format(camundaUri + endPointUri, taskId);
        String requestJsonForm = """
                {"userId": "%s"}
                """;
        String requestJson = String.format(requestJsonForm, userId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        log.info(url);
        this.restTemplate.postForObject(url, entity, Void.class);
    }
}
