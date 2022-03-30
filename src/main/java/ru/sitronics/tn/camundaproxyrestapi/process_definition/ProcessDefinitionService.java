package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import ru.sitronics.tn.camundaproxyrestapi.dto.ProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.StartProcessInstanceDto;

public interface ProcessDefinitionService {

    ProcessInstanceDto startProcess(String key, StartProcessInstanceDto StartProcessInstanceDto);
}
