package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    private String id;
    private String name;
    private String assignee;
    private Date created;
    private Date due;
    private Date followUp;
    private String delegationState;
    private String description;
    private String executionId;
    private String owner;
    private String parentTaskId;
    private int priority;
    private String processDefinitionId;
    private String processInstanceId;
    private String taskDefinitionKey;
}
