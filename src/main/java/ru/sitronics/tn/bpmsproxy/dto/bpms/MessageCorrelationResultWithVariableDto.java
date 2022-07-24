package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageCorrelationResultWithVariableDto extends MessageCorrelationResultDto {
    private Map<String, VariableValueDto> variables;
}
