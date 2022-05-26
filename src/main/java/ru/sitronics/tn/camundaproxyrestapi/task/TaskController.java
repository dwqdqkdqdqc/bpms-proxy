package ru.sitronics.tn.camundaproxyrestapi.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.camundaproxyrestapi.dto.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskQueryDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.UserIdDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<List<TaskDto>> getTasks(@RequestParam(defaultValue = "0") int firstResult,
                                                  @RequestParam(defaultValue = "20") int maxResults,
                                                  @RequestBody TaskQueryDto taskQueryDto) {
        return ResponseEntity.ok(taskService.getTasks(taskQueryDto, firstResult, maxResults));
    }

    @PostMapping("/{taskId}/claim")
    public ResponseEntity<Void> claimTask(@PathVariable String taskId, @Valid @RequestBody UserIdDto body) {
        taskService.claimTask(taskId, body);
        return ResponseEntity.noContent().build();
    }

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
