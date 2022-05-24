package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

@Data
public class LinkDto {
    private final String method;
    private final String href;
    private final String rel;
}
