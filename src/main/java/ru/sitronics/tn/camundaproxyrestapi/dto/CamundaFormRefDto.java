package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

@Data
public class CamundaFormRefDto {
    private final String key;
    private final String binding;
    private final int version;
}
