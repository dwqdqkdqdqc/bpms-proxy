package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VariableInstanceDto extends VariableValueDto {
    private String name;
    private String taskId;
}
