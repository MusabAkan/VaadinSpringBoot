package com.musakan.core.enums;

public enum EnumStatusType {
    ACTIVE("ACTIVE"),
    PASSIVE("PASSIVE");

    private final String status;

    EnumStatusType(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status != null ? status : "";
    }
}
