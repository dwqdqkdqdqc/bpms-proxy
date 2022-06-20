package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;

import java.util.Map;

@Data
public class CompleteTaskDto {
    private Map<String, VariableValueDto> variables;
    private boolean withVariablesInReturn;
}
