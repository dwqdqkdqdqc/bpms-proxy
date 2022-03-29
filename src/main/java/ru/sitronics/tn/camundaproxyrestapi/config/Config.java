package ru.sitronics.tn.camundaproxyrestapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.sitronics.tn.camundaproxyrestapi.process_definition.ProcessDefinitionService;
import ru.sitronics.tn.camundaproxyrestapi.process_definition.ProcessDefinitionServiceImpl;
import ru.sitronics.tn.camundaproxyrestapi.task.TaskService;
import ru.sitronics.tn.camundaproxyrestapi.task.TaskServiceImpl;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ProcessDefinitionService processDefinitionService(ProcessDefinitionServiceImpl processDefinitionService) {
        return processDefinitionService;
    }

    @Bean
    public TaskService taskService(TaskServiceImpl taskService) {
        return taskService;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
