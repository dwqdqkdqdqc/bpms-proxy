package ru.sitronics.tn.camundaproxyrestapi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.sitronics.tn.camundaproxyrestapi.process_definition.ProcessDefinitionService;
import ru.sitronics.tn.camundaproxyrestapi.process_definition.ProcessDefinitionServiceImpl;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ProcessDefinitionService processDefinitionService(ProcessDefinitionServiceImpl processDefinitionServiceImpl) {
        return processDefinitionServiceImpl;
    }
}
