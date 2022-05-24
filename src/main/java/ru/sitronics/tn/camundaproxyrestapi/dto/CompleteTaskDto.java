package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CompleteTaskDto {
    private final Map<String, VariableValueDto> variables;
    private final boolean withVariablesInReturn;
}
