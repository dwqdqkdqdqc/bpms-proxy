package ru.sitronics.tn.camundaproxyrestapi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;

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
    @PostMapping("/{taskId}/claim")
    public ResponseEntity<Void> claimTask(@PathVariable String taskId, @RequestBody String body) {
        taskService.claimTask(taskId, body);
        return ResponseEntity.noContent().build();
    }
}
