package ru.sitronics.tn.camundaproxyrestapi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        return new UndertowServletWebServerFactory();
    }

    @Override
    public void customize(UndertowServletWebServerFactory factory) {

    }
}
