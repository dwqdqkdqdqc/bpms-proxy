package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

@Data
public class VariableValueDto {
    private String type;
    private Object value;
}
