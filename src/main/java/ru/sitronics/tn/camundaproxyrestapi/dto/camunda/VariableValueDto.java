package ru.sitronics.tn.camundaproxyrestapi.dto.camunda;

import lombok.Data;

@Data
public class VariableValueDto {
    private String type;
    private Object value;
}
