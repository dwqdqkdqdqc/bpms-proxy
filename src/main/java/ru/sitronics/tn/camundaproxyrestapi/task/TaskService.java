package ru.sitronics.tn.camundaproxyrestapi.task;

import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.TaskQueryDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.UserIdDto;
import ru.sitronics.tn.camundaproxyrestapi.model.TaskType;

import java.util.List;
import java.util.Map;

public interface TaskService {
    Map<TaskType, String> getTaskTypes();
    List<TaskDto> getTasks(TaskQueryDto taskQueryDto, int firstResult, int maxResults);
    void claimTask(String taskId, UserIdDto userId);
    void unclaimTask(String taskId);
    Object completeTask(String taskId, CompleteTaskDto completeTaskDto);
}
