package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

@Data
public class TaskDto {
    private final String id;
    private final String name;
    private final String assignee;
    private final String created;
    private final String due;
    private final String followUp;
    private final String delegationState;
    private final String description;
    private final String executionId;
    private final String owner;
    private final String parentTaskId;
    private final String priority;
    private final String processDefinitionId;
    private final String processInstanceId;
    private final String caseDefinitionId;
    private final String caseInstanceId;
    private final String caseExecutionId;
    private final String taskDefinitionKey;
    private final boolean suspended;
    private final String formKey;
    private final CamundaFormRefDto camundaFormRef;
    private final String tenantId;
}
