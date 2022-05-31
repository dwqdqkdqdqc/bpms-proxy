package ru.sitronics.tn.camundaproxyrestapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="task_info")
public class TaskInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String processEngineTaskId;
    private String name;
    private String assignee;
    private LocalDateTime created;
    private LocalDateTime due;
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
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> candidateGroups;
    private String documentId;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;
    private boolean readByAssignee = false;
}
