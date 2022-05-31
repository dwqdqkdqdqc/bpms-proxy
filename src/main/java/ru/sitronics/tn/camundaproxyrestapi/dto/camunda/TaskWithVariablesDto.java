package ru.sitronics.tn.camundaproxyrestapi.dto.camunda;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskWithVariablesDto extends TaskDto {
    private Map<String, VariableValueDto> variables;
}
