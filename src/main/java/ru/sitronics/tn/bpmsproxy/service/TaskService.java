package ru.sitronics.tn.bpmsproxy.service;

import ru.sitronics.tn.bpmsproxy.dto.bpms.CompleteTaskDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.TaskDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.TaskQueryDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.UserIdDto;
import ru.sitronics.tn.bpmsproxy.model.TaskType;

import java.util.List;
import java.util.Map;

public interface TaskService {
    @Deprecated
    Map<TaskType, String> getTaskTypes();
    @Deprecated
    List<TaskDto> getTasks(TaskQueryDto taskQueryDto, int firstResult, int maxResults);
    @Deprecated
    void claimTask(String taskId, UserIdDto userId);
    @Deprecated
    void unclaimTask(String taskId);
    Object completeTask(String taskId, CompleteTaskDto completeTaskDto);
}
