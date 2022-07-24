package ru.sitronics.tn.bpmsproxy.dto;

import lombok.Data;

@Data
public class DeploymentRequest {
    private String processKey;
    private String schema;
}
