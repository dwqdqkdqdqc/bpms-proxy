package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;

import java.util.Map;

@Data
public class StartProcessInstanceDto {
    private String businessKey;
    private Map<String, VariableValueDto> variables;
    private boolean withVariablesInReturn;
}
