package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

@Data
public class TaskDto {
    String id;
    String name;
    String assignee;
    String created;
    String due;
    String followUp;
    String delegationState;
    String description;
    String executionId;
    String owner;
    String parentTaskId;
    String priority;
    String processDefinitionId;
    String processInstanceId;
    String caseDefinitionId;
    String caseInstanceId;
    String caseExecutionId;
    String taskDefinitionKey;
    boolean suspended;
    String formKey;
    CamundaFormRefDto camundaFormRef;
    String tenantId;
}
