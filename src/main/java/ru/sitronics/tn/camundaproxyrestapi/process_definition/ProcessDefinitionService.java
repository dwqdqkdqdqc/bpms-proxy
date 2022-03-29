package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import ru.sitronics.tn.camundaproxyrestapi.dto.ProcessInstanceDto;

public interface ProcessDefinitionService {

    ProcessInstanceDto startProcess(String id);
}
