package ru.sitronics.tn.camundaproxyrestapi.dto.camunda;

import lombok.Data;

import java.util.List;

@Data
public class TaskQueryDto {
    private String assignee;
    private List<String> candidateGroups;
    private List<TaskQueryDto> orQueries;
    private List<SortingDto> sorting;
}
