package ru.sitronics.tn.camundaproxyrestapi.task;

import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.UserIdDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getTaskByAssignee(String assignee, int firstResult, int maxResults);

    void claimTask(String taskId, UserIdDto userId);

    void unclaimTask(String taskId);

    Object completeTask(String taskId, CompleteTaskDto completeTaskDto);
}
