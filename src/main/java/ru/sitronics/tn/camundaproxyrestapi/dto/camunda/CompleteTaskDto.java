package ru.sitronics.tn.camundaproxyrestapi.dto.camunda;

import lombok.Data;

import java.util.Map;

@Data
public class CompleteTaskDto {
    private Map<String, VariableValueDto> variables;
    private boolean withVariablesInReturn;
}
