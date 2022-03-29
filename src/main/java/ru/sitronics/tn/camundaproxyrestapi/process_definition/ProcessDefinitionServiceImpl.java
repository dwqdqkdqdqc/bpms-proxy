package ru.sitronics.tn.camundaproxyrestapi.process_definition;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.camundaproxyrestapi.dto.ProcessInstanceDto;
import ru.sitronics.tn.camundaproxyrestapi.util.CustomRestUtil;

@Service
@RequiredArgsConstructor
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {

    private final CustomRestUtil customRestUtil;

    @Override
    public ProcessInstanceDto startProcess(String key) {
        String endPointUri = String.format("/process-definition/key/%s/start", key) ;
        String requestBody = "{}";
        return customRestUtil.post(endPointUri, requestBody, ProcessInstanceDto.class);
    }
}
