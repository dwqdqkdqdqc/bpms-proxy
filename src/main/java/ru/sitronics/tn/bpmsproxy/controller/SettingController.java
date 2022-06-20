package ru.sitronics.tn.bpmsproxy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sitronics.tn.bpmsproxy.service.SettingService;

@RestController
@RequestMapping("/settings")
@RequiredArgsConstructor
@Deprecated
public class SettingController {

    private final SettingService settingsService;

    @GetMapping
    public ResponseEntity<String> getSetting(@RequestParam String setting) {
        return ResponseEntity.ok(settingsService.getSetting(setting));
    }
}
