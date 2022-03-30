package ru.sitronics.tn.camundaproxyrestapi.task;

import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.UserIdDto;

@Service
public interface TaskService {

    TaskDto[] getTaskByAssignee(String assignee);

    void claimTask(String taskId, UserIdDto userId);

    void unclaimTask(String taskId);

    Object completeTask(String taskId, CompleteTaskDto completeTaskDto);
}
