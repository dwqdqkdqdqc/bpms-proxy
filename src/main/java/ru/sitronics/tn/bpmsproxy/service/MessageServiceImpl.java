package ru.sitronics.tn.bpmsproxy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.bpmsproxy.dto.bpms.CorrelationMessageDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.MessageCorrelationResultDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.MessageCorrelationResultWithVariableDto;
import ru.sitronics.tn.bpmsproxy.util.CustomRestClient;


@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final CustomRestClient customRestClient;
    @Override
    public MessageCorrelationResultDto correlateMessage(CorrelationMessageDto correlationMessageDto) {
        String endPointUri = "/message";
        return customRestClient.postJson(endPointUri, correlationMessageDto, MessageCorrelationResultWithVariableDto.class);
    }
}
