package ru.sitronics.tn.bpmsproxy.dto.bpms;

import lombok.Data;

@Data
public class ProcessInstanceDto {
    private String id;
    private String definitionId;
    private boolean ended;
    private boolean suspended;
}
