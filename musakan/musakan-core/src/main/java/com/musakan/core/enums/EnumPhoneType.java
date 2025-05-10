package com.musakan.core.enums;

public enum EnumPhoneType {
    GSM("GSM"),
    LANDLINE_TELEPHONE("Sabit Telefon"),
    FAX("Faks"),
    OTHER("Diğer");

    private final String type;

    EnumPhoneType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type != null ? type : null;
    }
}
