package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

import java.util.Map;

@Data
public class VariableValueDto {
    private String type;
    private Object value;
    private Map<String, Object> valueInfo;
}
