package ru.sitronics.tn.bpmsproxy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.bpmsproxy.dto.bpms.ProcessInstanceDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.ProcessInstanceWithVariablesDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.StartProcessInstanceDto;
import ru.sitronics.tn.bpmsproxy.util.CustomRestClient;

@Service
@RequiredArgsConstructor
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {
    private final CustomRestClient customRestClient;

    @Override
    public ProcessInstanceDto startProcessByKey(String processKey, StartProcessInstanceDto startProcessInstanceDto) {
        String endPointUri = String.format("/process-definition/key/%s/start", processKey);
        return customRestClient.postJson(endPointUri, startProcessInstanceDto, ProcessInstanceWithVariablesDto.class);
    }
}
