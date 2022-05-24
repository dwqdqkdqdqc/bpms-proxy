package ru.sitronics.tn.camundaproxyrestapi.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.UserIdDto;
import ru.sitronics.tn.camundaproxyrestapi.util.CustomRestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final CustomRestClient customRestClient;

    @Override
    public List<TaskDto> getTaskByAssignee(String assignee, int firstResult, int maxResults) {
        String endPointUri = String.format("/task?assignee=%s&firstResult=%s&maxResults=%s", assignee, firstResult, maxResults);
        return customRestClient.getList(endPointUri, TaskDto[].class);
    }

    @Override
    public void claimTask(String taskId, UserIdDto body) {
        String endPointUri = String.format("/task/%s/claim", taskId);
        customRestClient.post(endPointUri, body, Void.class);
    }

    @Override
    public void unclaimTask(String taskId) {
        String endPointUri = String.format("/task/%s/unclaim", taskId);
        customRestClient.post(endPointUri, Void.class);
    }

    @Override
    public Object completeTask(String taskId, CompleteTaskDto completeTaskDto) {
        String endPointUri = String.format("/task/%s/complete", taskId);
        return customRestClient.post(endPointUri, completeTaskDto, Object.class);
    }
}
