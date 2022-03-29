package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sitronics.tn.camundaproxyrestapi.dto.ProcessInstanceDto;

//TODO Validation

@RestController
@RequestMapping("/process-definition")
@RequiredArgsConstructor
public class ProcessDefinitionController {

    private final ProcessDefinitionService processDefinitionService;

    @PostMapping("/key/{key}/start")
    public ResponseEntity<ProcessInstanceDto> startProcess(@PathVariable String key) {
        return ResponseEntity.ok(processDefinitionService.startProcess(key));
    }
}
