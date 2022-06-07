package ru.sitronics.tn.camundaproxyrestapi.task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.*;
import ru.sitronics.tn.camundaproxyrestapi.model.TaskType;
import ru.sitronics.tn.camundaproxyrestapi.util.CustomRestClient;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final CustomRestClient customRestClient;

    @Override
    public Map<TaskType, String> getTaskTypes() {
        Map<TaskType, String> m = new EnumMap<>(TaskType.class);
        Arrays.asList(TaskType.values()).forEach(el -> m.put(el, el.getDisplayValue()));
        return m;
    }

    @Override
    @Deprecated
    public List<TaskDto> getTasks(TaskQueryDto taskQueryDto, int firstResult, int maxResults) {
        String endPointUri = String.format("/task?firstResult=%s&maxResults=%s", firstResult, maxResults);
        TaskDto[] taskDtos = customRestClient.postJson(endPointUri, taskQueryDto, TaskDto[].class);
        String[] taskIds = Arrays.stream(taskDtos)
                .map(TaskDto::getId).toArray(String[]::new);
        VariableInstanceQueryDto variableInstanceQueryDto = new VariableInstanceQueryDto();
        variableInstanceQueryDto.setTaskIdIn(taskIds);
        VariableInstanceDto[] variableInstanceDtos = customRestClient
                .postJson("/variable-instance", variableInstanceQueryDto, VariableInstanceDto[].class);
        return Arrays.stream(taskDtos)
                .map(taskDto -> {
                    TaskWithVariablesDto taskWithVariablesDto = new TaskWithVariablesDto();
                    BeanUtils.copyProperties(taskDto, taskWithVariablesDto);
                    Map<String, VariableValueDto> variables = new HashMap<>();
                    Arrays.stream(variableInstanceDtos)
                            .filter(variableInstanceDto -> variableInstanceDto.getTaskId().equals(taskDto.getId()))
                            .forEach(variableInstanceDto -> {
                                VariableValueDto variableValueDto = new VariableValueDto();
                                BeanUtils.copyProperties(variableInstanceDto, variableValueDto);
                                variables.put(variableInstanceDto.getName(), variableValueDto);
                            });
                    if (!variables.isEmpty()) {
                        taskWithVariablesDto.setVariables(variables);
                    }
                    return taskWithVariablesDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void claimTask(String taskId, UserIdDto body) {
        String endPointUri = String.format("/task/%s/claim", taskId);
        customRestClient.postJson(endPointUri, body, Void.class);
    }

    @Override
    public void unclaimTask(String taskId) {
        String endPointUri = String.format("/task/%s/unclaim", taskId);
        customRestClient.post(endPointUri, Void.class);
    }

    @Override
    public Object completeTask(String taskId, CompleteTaskDto completeTaskDto) {
        String endPointUri = String.format("/task/%s/complete", taskId);
        return customRestClient.postJson(endPointUri, completeTaskDto, Object.class);
    }
}
