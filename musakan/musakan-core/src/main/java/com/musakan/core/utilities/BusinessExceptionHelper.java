package com.musakan.core.utilities;

public class BusinessExceptionHelper extends RuntimeException {

    public BusinessExceptionHelper(String message) {
        super(message != null ? message : "Hata oluştu");
        throwThis();
    }

    private void throwThis() {
        throw this;
    }
}