package ru.sitronics.tn.camundaproxyrestapi.bpm;

import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import ru.sitronics.tn.camundaproxyrestapi.dto.DeploymentDto;
import ru.sitronics.tn.camundaproxyrestapi.model.BpmSchema;
import ru.sitronics.tn.camundaproxyrestapi.repository.BpmRepository;
import ru.sitronics.tn.camundaproxyrestapi.util.CustomRestClient;
import ru.sitronics.tn.camundaproxyrestapi.util.DeploymentParams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BpmService {
    private final BpmRepository bpmRepository;
    private final CustomRestClient customRestClient;

    public List<BpmSchema> getSchemes() {
        return bpmRepository.findAll();
    }

    public Optional<BpmSchema> getSchema(Long id) {
        return bpmRepository.findById(id);
    }

    public BpmSchema saveSchema(BpmSchema schema) {
        return bpmRepository.save(schema);
    }

    public BpmSchema deploy(BpmSchema schema) {
        try {
            schema = saveSchema(schema);
            LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add(DeploymentParams.DEPLOYMENT_NAME.getValue(), schema.getProcessName());
            params.add("file", CustomRestClient.makeTempFile(schema.getXml().getBytes(StandardCharsets.UTF_8)));
            DeploymentDto response = customRestClient.postForm("/deployment/create", params, DeploymentDto.class);
            return schema;
        } catch (IOException e) {
            throw new InternalException("Can't make temporary file.");
        }
    }
}

