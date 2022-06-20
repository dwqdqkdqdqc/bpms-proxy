package ru.sitronics.tn.bpmsproxy.service;

import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import ru.sitronics.tn.bpmsproxy.dto.DeploymentDto;
import ru.sitronics.tn.bpmsproxy.exception.CustomApplicationException;
import ru.sitronics.tn.bpmsproxy.model.BpmSchema;
import ru.sitronics.tn.bpmsproxy.repository.BpmRepository;
import ru.sitronics.tn.bpmsproxy.util.CustomRestClient;
import ru.sitronics.tn.bpmsproxy.util.DeploymentParams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
@Deprecated
public class BpmService {
    private final BpmRepository bpmRepository;
    private final CustomRestClient customRestClient;

    public List<BpmSchema> getSchemes() {
        return bpmRepository.findAll();
    }

    public BpmSchema getSchema(Long id) {
        return bpmRepository.findById(id).orElseThrow(() -> new CustomApplicationException("Wrong ID"));
    }

    public BpmSchema saveSchema(BpmSchema schema) {
        return bpmRepository.save(schema);
    }

    public BpmSchema deploy(Long id) {
        try {
            BpmSchema schema = getSchema(id);
            LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add(DeploymentParams.DEPLOYMENT_NAME.getValue(), schema.getProcessName());
            params.add("file", CustomRestClient.makeTempFile(schema.getXml().getBytes(StandardCharsets.UTF_8)));
            DeploymentDto response = customRestClient.postForm("/deployment/create", params, DeploymentDto.class);
            schema.setDeployed(true);
            return saveSchema(schema);
        } catch (IOException e) {
            throw new InternalException("Can't make temporary file.");
        }
    }
}

