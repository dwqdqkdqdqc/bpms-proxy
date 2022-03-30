package ru.sitronics.tn.camundaproxyrestapi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.camundaproxyrestapi.dto.CompleteTaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.UserIdDto;

import javax.validation.Valid;

//TODO Validation

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<TaskDto[]> getTaskByAssignee(@RequestParam String assignee) {
        return ResponseEntity.ok(taskService.getTaskByAssignee(assignee));
    }

    //TODO JSON validator for request body
    //TODO Body not null
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

    //TODO JSON validator for request body
    @PostMapping("/{taskId}/complete")
    public ResponseEntity<Object> completeTask(@PathVariable String taskId,
                                               @RequestBody CompleteTaskDto completeTaskDto) {
        return ResponseEntity.ok(taskService.completeTask(taskId, completeTaskDto));
    }
}
