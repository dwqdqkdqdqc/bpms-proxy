package ru.sitronics.tn.bpmsproxy.dto;

import lombok.Data;

import java.util.Date;

@Data
@Deprecated
public class DeploymentDto {
    private String id;
    private String name;
    private String source;
    private Date deploymentTime;
    private String tenantId;
}
