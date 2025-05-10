package com.musakan.core.enums;

public enum EnumGenderType {
    MALE("Erkek"),
    FEMALE("Kadın"),
    UNKNOWN("Bilinmiyor");

    private final String gender;

    EnumGenderType(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender != null ? gender : "";
    }
}
