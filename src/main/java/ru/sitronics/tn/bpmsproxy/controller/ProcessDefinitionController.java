package ru.sitronics.tn.bpmsproxy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.bpmsproxy.dto.bpms.ProcessInstanceDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.StartProcessInstanceDto;
import ru.sitronics.tn.bpmsproxy.service.ProcessDefinitionService;

@RestController
@RequestMapping("/process-definition")
@RequiredArgsConstructor
public class ProcessDefinitionController {

    private final ProcessDefinitionService processDefinitionService;

    @PostMapping("/key/{processKey}/start")
    public ResponseEntity<ProcessInstanceDto> startProcessByKey(@PathVariable String processKey,
                                                                @RequestBody StartProcessInstanceDto startProcessInstanceDto) {
        return ResponseEntity.ok(processDefinitionService.startProcessByKey(processKey, startProcessInstanceDto));
    }
}
