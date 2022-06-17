package ru.sitronics.tn.bpmsproxy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BpmsApiExceptionDto {
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
}
