package ru.sitronics.tn.bpmsproxy.service;

import ru.sitronics.tn.bpmsproxy.dto.bpms.CompleteTaskDto;

public interface TaskService {
    Object completeTask(String taskId, CompleteTaskDto completeTaskDto);
}
