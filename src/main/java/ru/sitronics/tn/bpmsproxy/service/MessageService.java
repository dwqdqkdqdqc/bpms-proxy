package ru.sitronics.tn.bpmsproxy.service;

import ru.sitronics.tn.bpmsproxy.dto.bpms.CorrelationMessageDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.MessageCorrelationResultDto;

public interface MessageService {
    MessageCorrelationResultDto correlateMessage(CorrelationMessageDto correlationMessageDto);
}
