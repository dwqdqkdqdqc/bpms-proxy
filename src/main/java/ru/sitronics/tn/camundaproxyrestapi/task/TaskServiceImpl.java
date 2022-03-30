package ru.sitronics.tn.camundaproxyrestapi.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.UserIdDto;
import ru.sitronics.tn.camundaproxyrestapi.util.CustomRestUtil;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final CustomRestUtil customRestUtil;

    @Override
    public TaskDto[] getTaskByAssignee(String assignee) {
        String endPointUri = String.format("/task?assignee=%s", assignee);
        return customRestUtil.get(endPointUri, TaskDto[].class);
    }

    @Override
    public void claimTask(String taskId, UserIdDto body) {
        String endPointUri = String.format("/task/%s/claim", taskId);
        customRestUtil.post(endPointUri, body, Void.class);
    }

    @Override
    public void unclaimTask(String taskId) {
        String endPointUri = String.format("/task/%s/unclaim", taskId);
        customRestUtil.post(endPointUri, Void.class);
    }

    @Override
    public Object completeTask(String taskId, CompleteTaskDto completeTaskDto) {
        String endPointUri = String.format("/task/%s/complete", taskId);
        return customRestUtil.post(endPointUri, completeTaskDto, Object.class);
    }
}
