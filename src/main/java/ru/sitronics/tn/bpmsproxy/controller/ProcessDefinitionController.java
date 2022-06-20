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

    @PostMapping("/start-by-document-type")
    @Deprecated
    public ResponseEntity<ProcessInstanceDto> startProcessByDocumentType(@RequestParam String documentType,
                                                                         @RequestParam String documentId,
                                                                         @RequestParam String startedBy,
                                                                         @RequestBody StartProcessInstanceDto startProcessInstanceDto) {
        return ResponseEntity.ok(processDefinitionService.startProcessByDocumentType(documentType, documentId, startedBy, startProcessInstanceDto));
    }

    @PostMapping("/key/{processKey}/start")
    public ResponseEntity<ProcessInstanceDto> startProcessByKey(@PathVariable String processKey,
                                                                @RequestBody StartProcessInstanceDto startProcessInstanceDto) {
        return ResponseEntity.ok(processDefinitionService.startProcessByKey(processKey, startProcessInstanceDto));
    }
}
