package ru.sitronics.tn.camundaproxyrestapi.task;

import ru.sitronics.tn.camundaproxyrestapi.dto.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskQueryDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.UserIdDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getTasks(TaskQueryDto taskQueryDto, int firstResult, int maxResults);

    void claimTask(String taskId, UserIdDto userId);

    void unclaimTask(String taskId);

    Object completeTask(String taskId, CompleteTaskDto completeTaskDto);
}
