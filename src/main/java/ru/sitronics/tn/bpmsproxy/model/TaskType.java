package ru.sitronics.tn.bpmsproxy.model;

@Deprecated
public enum TaskType {
    APPROVAL("Согласование"),
    FAMILIARIZATION("Ознакомление");

    private final String displayValue;

    TaskType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
