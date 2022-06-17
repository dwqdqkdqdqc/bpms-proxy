package ru.sitronics.tn.bpmsproxy.service;

import ru.sitronics.tn.bpmsproxy.dto.bpms.ProcessInstanceDto;
import ru.sitronics.tn.bpmsproxy.dto.bpms.StartProcessInstanceDto;

public interface ProcessDefinitionService {
    ProcessInstanceDto startProcessByDocumentType(String documentType, String documentId, String startedBy, StartProcessInstanceDto startProcessInstanceDto);
    ProcessInstanceDto startProcessByKey(String processKey, StartProcessInstanceDto startProcessInstanceDto);
}
