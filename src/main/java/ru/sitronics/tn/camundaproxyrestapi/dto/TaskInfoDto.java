package ru.sitronics.tn.camundaproxyrestapi.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ru.sitronics.tn.camundaproxyrestapi.model.TaskType;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskInfoDto {
    private Long id;
    private String processEngineTaskId;
    private String name;
    private String assignee;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime due;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime followUp;
    private String delegationState;
    private String description;
    private String executionId;
    private String owner;
    private String parentTaskId;
    private int priority;
    private String processDefinitionId;
    private String processInstanceId;
    private String taskDefinitionKey;
    private List<String> candidateGroups;
    private String documentId;
    private TaskType taskType;
    private boolean readByAssignee = false;
}
