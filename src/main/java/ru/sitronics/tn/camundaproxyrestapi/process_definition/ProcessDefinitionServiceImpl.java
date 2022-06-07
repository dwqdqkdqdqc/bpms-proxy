package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.ProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.ProcessInstanceWithVariablesDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.StartProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.dto.camunda.VariableValueDto;
import ru.sitronics.tn.camundaproxyrestapi.exception.ProcessDocumentMappingException;
import ru.sitronics.tn.camundaproxyrestapi.repository.ProcessDocumentMappingRepository;
import ru.sitronics.tn.camundaproxyrestapi.util.CustomRestClient;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {
    private final CustomRestClient customRestClient;
    private final ProcessDocumentMappingRepository processDocumentMappingRepository;

    @Override
    public ProcessInstanceDto startProcessByDocumentType(String documentType, String documentId, String startedBy, StartProcessInstanceDto startProcessInstanceDto) {
        VariableValueDto documentIdVariable = new VariableValueDto();
        documentIdVariable.setType("String");
        documentIdVariable.setValue(documentId);

        VariableValueDto startedByIdVariable = new VariableValueDto();
        startedByIdVariable.setType("String");
        startedByIdVariable.setValue(startedBy);

        Map<String, VariableValueDto> variableValueDtoMap = startProcessInstanceDto.getVariables();

        if(variableValueDtoMap == null) {
            variableValueDtoMap = new HashMap<>();
        }

        variableValueDtoMap.put("documentId", documentIdVariable);
        variableValueDtoMap.put("startedBy", startedByIdVariable);

        startProcessInstanceDto.setVariables(variableValueDtoMap);

        String processKey = getProcessKeyByDocumentName(documentType);
        String endPointUri = String.format("/process-definition/key/%s/start", processKey);
        return customRestClient.postJson(endPointUri, startProcessInstanceDto, ProcessInstanceWithVariablesDto.class);
    }

    @Override
    public ProcessInstanceDto startProcessByKey(String processKey, StartProcessInstanceDto startProcessInstanceDto) {
        String endPointUri = String.format("/process-definition/key/%s/start", processKey);
        return customRestClient.postJson(endPointUri, startProcessInstanceDto, ProcessInstanceWithVariablesDto.class);
    }

    private String getProcessKeyByDocumentName(String documentType) {
        return processDocumentMappingRepository
                .findByDocumentType(documentType)
                .orElseThrow(() -> new ProcessDocumentMappingException(String.format("Couldn't find a process by document type: %s", documentType)))
                .getProcessName();
    }
}
