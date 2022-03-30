package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProcessInstanceWithVariablesDto extends ProcessInstanceDto {

    private Map<String, VariableValueDto> variables;
}
