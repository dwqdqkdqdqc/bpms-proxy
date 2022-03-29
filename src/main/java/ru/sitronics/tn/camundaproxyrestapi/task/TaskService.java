package ru.sitronics.tn.camundaproxyrestapi.task;

import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDto> getTaskByAssignee(String assignee);
    void claimTask(String id, String userId);
}
