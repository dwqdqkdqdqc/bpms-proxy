package ru.sitronics.tn.bpmsproxy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.bpmsproxy.dto.bpms.CompleteTaskDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.TaskDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.TaskQueryDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.UserIdDto;
import ru.sitronics.tn.bpmsproxy.model.TaskType;
import ru.sitronics.tn.bpmsproxy.service.TaskService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @Deprecated
    @GetMapping("/types")
    public ResponseEntity<Map<TaskType, String>> getTaskTypes() {
        return ResponseEntity.ok(taskService.getTaskTypes());
    }

    @Deprecated
    @PostMapping
    public ResponseEntity<List<TaskDto>> getTasks(@RequestParam(defaultValue = "0") int firstResult,
                                                  @RequestParam(defaultValue = "20") int maxResults,
                                                  @RequestBody TaskQueryDto taskQueryDto) {
        return ResponseEntity.ok(taskService.getTasks(taskQueryDto, firstResult, maxResults));
    }

    @Deprecated
    @PostMapping("/{taskId}/claim")
    public ResponseEntity<Void> claimTask(@PathVariable String taskId, @Valid @RequestBody UserIdDto body) {
        taskService.claimTask(taskId, body);
        return ResponseEntity.noContent().build();
    }

    @Deprecated
    @PostMapping("/{taskId}/unclaim")
    public ResponseEntity<Void> unclaimTask(@PathVariable String taskId) {
        taskService.unclaimTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{taskId}/complete")
    public ResponseEntity<Object> completeTask(@PathVariable String taskId,
                                               @RequestBody CompleteTaskDto completeTaskDto) {
        return ResponseEntity.ok(taskService.completeTask(taskId, completeTaskDto));
    }
}
