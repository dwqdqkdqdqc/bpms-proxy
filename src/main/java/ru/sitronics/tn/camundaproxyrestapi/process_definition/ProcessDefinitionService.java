package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.ProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.StartProcessInstanceDto;

public interface ProcessDefinitionService {
    ProcessInstanceDto startProcessByDocumentType(String documentType, String documentId, String startedBy, StartProcessInstanceDto startProcessInstanceDto);
}
