package ru.sitronics.tn.camundaproxyrestapi.task;

import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;

@Service
public interface TaskService {

    TaskDto[] getTaskByAssignee(String assignee);

    void claimTask(String id, String userId);
}
