package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Deprecated
public class TaskWithVariablesDto extends TaskDto {
    private Map<String, VariableValueDto> variables;
}
