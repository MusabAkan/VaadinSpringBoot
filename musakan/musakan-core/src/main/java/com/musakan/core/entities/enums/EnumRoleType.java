package com.musakan.core.entities.enums;

public enum EnumRoleType {
    CUSTOMER("Müşteri"),
    ADMIN("Admin"),
    STAFF("Personel");

    private final String roleType;

    EnumRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return roleType != null ? roleType : null;
    }
}
