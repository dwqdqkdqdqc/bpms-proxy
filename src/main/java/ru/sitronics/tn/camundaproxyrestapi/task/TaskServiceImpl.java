package ru.sitronics.tn.camundaproxyrestapi.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
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
    public void claimTask(String taskId, String body) {
        String endPointUri = String.format("/task/%s/claim", taskId);
        customRestUtil.post(endPointUri, body, Void.class);
    }
}
