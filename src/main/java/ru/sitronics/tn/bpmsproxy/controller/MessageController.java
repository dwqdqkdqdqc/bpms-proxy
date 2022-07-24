package ru.sitronics.tn.bpmsproxy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sitronics.tn.bpmsproxy.dto.bpms.CorrelationMessageDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.MessageCorrelationResultDto;
import ru.sitronics.tn.bpmsproxy.service.MessageService;

@RestController
@RequestMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageCorrelationResultDto> correlateMessage(@RequestBody CorrelationMessageDto correlationMessageDto) {
        return ResponseEntity.ok(messageService.correlateMessage(correlationMessageDto));
    }
}
