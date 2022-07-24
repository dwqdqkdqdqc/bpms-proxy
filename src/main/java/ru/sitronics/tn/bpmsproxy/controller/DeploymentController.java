package ru.sitronics.tn.bpmsproxy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.bpmsproxy.dto.DeploymentRequest;
import ru.sitronics.tn.bpmsproxy.service.DeploymentService;

@RestController
@RequestMapping("/deployment")
@RequiredArgsConstructor
public class DeploymentController {
    private final DeploymentService deploymentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DeploymentRequest deploymentRequest) {
        return ResponseEntity.ok(deploymentService.create(deploymentRequest));
    }
}
