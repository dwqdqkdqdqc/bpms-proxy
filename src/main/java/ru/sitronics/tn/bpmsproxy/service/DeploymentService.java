package ru.sitronics.tn.bpmsproxy.service;

import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import ru.sitronics.tn.bpmsproxy.dto.DeploymentRequest;
import ru.sitronics.tn.bpmsproxy.dto.bpms.DeploymentDto;
import ru.sitronics.tn.bpmsproxy.util.CustomRestClient;
import ru.sitronics.tn.bpmsproxy.util.DeploymentParams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class DeploymentService {
    private final CustomRestClient customRestClient;

    public Object create(DeploymentRequest deploymentRequest) {
        try {
            LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add(DeploymentParams.DEPLOYMENT_NAME.getValue(), deploymentRequest.getProcessKey());
            params.add("file", CustomRestClient.makeTempFile(deploymentRequest.getSchema().getBytes(StandardCharsets.UTF_8)));
            return customRestClient.postForm("/deployment/create", params, DeploymentDto.class);
        } catch (IOException e) {
            throw new InternalException("Can't make temporary file.");
        }
    }
}
