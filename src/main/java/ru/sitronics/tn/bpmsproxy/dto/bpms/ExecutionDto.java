package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;

@Data
public class ExecutionDto {
    private String id;
    private String processInstanceId;
    private boolean ended;
    private String tenantId;
}
