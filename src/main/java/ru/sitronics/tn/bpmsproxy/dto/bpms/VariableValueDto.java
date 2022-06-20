package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;

@Data
public class VariableValueDto {
    private String type;
    private Object value;
}
