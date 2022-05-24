package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProcessInstanceDto {
    private List<LinkDto> links;
    private String id;
    private String definitionId;
    private String businessKey;
    private String caseInstanceId;
    private String tenantId;
    private boolean ended;
    private boolean suspended;
}
