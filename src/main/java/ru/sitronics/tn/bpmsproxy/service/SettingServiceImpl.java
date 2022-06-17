package ru.sitronics.tn.bpmsproxy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Deprecated
public class SettingServiceImpl implements SettingService {

    @Value("${external-services.documents.host}")
    private String documentsHost;
    @Value("${external-services.documents.port}")
    private String documentsPort;
    @Value("${external-services.tasks.host}")
    private String tasksHost;
    @Value("${external-services.tasks.port}")
    private String tasksPort;
    @Value("${external-services.notifications.host}")
    private String notificationsHost;
    @Value("${external-services.notifications.port}")
    private String notificationsPort;

    @Override
    public String getSetting(String setting) {

        Map<String, String> settings = new HashMap<>();
        String responseJson = "{\"url\":\"%s\"}";

        settings.put("documents", documentsHost + ":" + documentsPort);
        settings.put("tasks", tasksHost + ":" + tasksPort);
        settings.put("notifications", notificationsHost + ":" + notificationsPort);

        return responseJson.formatted(settings.getOrDefault(setting, "none"));
    }
}
