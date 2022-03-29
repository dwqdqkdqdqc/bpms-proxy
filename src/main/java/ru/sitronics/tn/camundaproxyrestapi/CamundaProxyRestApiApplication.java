package ru.sitronics.tn.camundaproxyrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class CamundaProxyRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaProxyRestApiApplication.class, args);
	}

}
