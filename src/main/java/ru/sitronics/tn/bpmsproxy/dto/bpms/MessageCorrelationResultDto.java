package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;

@Data
public class MessageCorrelationResultDto {
    private MessageCorrelationResultType resultType;
    private ExecutionDto execution;
    private ProcessInstanceDto processInstance;
}
