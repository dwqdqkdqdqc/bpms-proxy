package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;

import java.util.Map;

@Data
public class StartProcessInstanceDto {
    private Map<String, VariableValueDto> variables;
    private boolean withVariablesInReturn;
}
