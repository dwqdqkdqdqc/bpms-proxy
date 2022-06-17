package ru.sitronics.tn.bpmsproxy.service;

import ru.sitronics.tn.bpmsproxy.dto.TaskInfoDto;

import java.util.List;

@Deprecated
public interface TaskInfoService {
    TaskInfoDto createTaskInfo(TaskInfoDto taskInfoDto);
    List<TaskInfoDto> getAllTaskInfo();
}
