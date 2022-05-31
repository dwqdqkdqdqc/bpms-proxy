package ru.sitronics.tn.camundaproxyrestapi.dto.camunda;

import lombok.Data;

@Data
public class VariableInstanceQueryDto {
    private String[] taskIdIn;
}
