package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProcessInstanceDto {
    private final List<LinkDto> links;
    private final String id;
    private final String definitionId;
    private final String businessKey;
    private final String caseInstanceId;
    private final String tenantId;
    private final boolean ended;
    private final boolean suspended;
}
