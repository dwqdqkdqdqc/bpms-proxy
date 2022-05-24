package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

import java.util.Map;

@Data
public class StartProcessInstanceDto {

    private Map<String, VariableValueDto> variables;
    private String businessKey;
    private String caseInstanceId;
    private boolean skipCustomListeners;
    private boolean skipIoMappings;
    private boolean withVariablesInReturn = false;
}
