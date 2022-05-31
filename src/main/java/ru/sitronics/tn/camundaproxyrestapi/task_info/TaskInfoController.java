package ru.sitronics.tn.camundaproxyrestapi.task_info;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.camundaproxyrestapi.dto.TaskInfoDto;

import java.util.List;

@RestController
@RequestMapping("/task-info")
@RequiredArgsConstructor
public class TaskInfoController {

    private final TaskInfoService taskInfoService;

    @InitBinder    /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @PostMapping
    public ResponseEntity<TaskInfoDto> createTaskInfo(@RequestBody TaskInfoDto taskInfoDto) {
        return ResponseEntity.ok(taskInfoService.createTaskInfo(taskInfoDto));
    }

    @GetMapping
    public ResponseEntity<List<TaskInfoDto>> getAllTaskInfo() {
        return ResponseEntity.ok(taskInfoService.getAllTaskInfo());
    }
}
