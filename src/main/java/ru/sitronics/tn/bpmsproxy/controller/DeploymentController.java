package ru.sitronics.tn.bpmsproxy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sitronics.tn.bpmsproxy.service.DeploymentService;

@RestController
@RequestMapping("/deployment")
@RequiredArgsConstructor
public class DeploymentController {
    private final DeploymentService deploymentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestParam String processKey, @RequestParam String schema) {
        return ResponseEntity.ok(deploymentService.create(processKey, schema));
    }
}
