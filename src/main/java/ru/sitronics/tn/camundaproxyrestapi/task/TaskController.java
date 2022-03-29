package ru.sitronics.tn.camundaproxyrestapi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskDto;

import java.util.List;

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
    public ResponseEntity<List<TaskDto>> getTaskByAssignee(@RequestParam String assignee) {
        return ResponseEntity.ok(taskService.getTaskByAssignee(assignee));
    }

    @PostMapping("/{taskId}/claim")
    public ResponseEntity<Void> claimTask(@PathVariable String taskId, @RequestBody String userId) {
        taskService.claimTask(taskId, userId);
        return ResponseEntity.noContent().build();
    }
}
