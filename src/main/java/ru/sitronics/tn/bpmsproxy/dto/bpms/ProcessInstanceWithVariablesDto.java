package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProcessInstanceWithVariablesDto extends ProcessInstanceDto {
    private Map<String, VariableValueDto> variables;
}
