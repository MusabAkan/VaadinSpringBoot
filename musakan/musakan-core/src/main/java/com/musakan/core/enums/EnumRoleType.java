package com.musakan.core.enums;

public enum EnumRoleType {
    SUPER_ADMIN("Süper Admin"),
    ADMIN("Admin"),
    CUSTOMER("Müşteri");

    private final String roleType;

    EnumRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return roleType != null ? roleType : "";
    }
}
