package com.musakan.core.entities.enums;

public enum EnumGenderType {
    MALE("Erkek"),
    FEMALE("Kadın");

    private final String gender;

    EnumGenderType(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender != null ? gender : null;
    }
}
