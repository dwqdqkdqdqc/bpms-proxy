package ru.sitronics.tn.camundaproxyrestapi.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeploymentParams {
    DEPLOYMENT_NAME("deployment-name"),
    DEPLOYMENT_ACTIVATION_TIME("deployment-activation-time"),
    ENABLE_DUPLICATE_FILTERING("enable-duplicate-filtering"),
    DEPLOY_CHANGED_ONLY("deploy-changed-only"),
    DEPLOYMENT_SOURCE("deployment-source"),
    TENANT_ID("tenant-id");

    private final String value;
}

