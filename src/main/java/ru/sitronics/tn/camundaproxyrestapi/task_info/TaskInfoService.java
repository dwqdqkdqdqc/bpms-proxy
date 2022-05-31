package ru.sitronics.tn.camundaproxyrestapi.task_info;

import ru.sitronics.tn.camundaproxyrestapi.dto.TaskInfoDto;

import java.util.List;

public interface TaskInfoService {
    TaskInfoDto createTaskInfo(TaskInfoDto taskInfoDto);
    List<TaskInfoDto> getAllTaskInfo();
}
