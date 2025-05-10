package com.musakan.core.utilities;

/**
 * Hata  fırlatma için kullanılan yardımcı sınıf
 * @author Musakan
 */
public class BusinessExceptionHelper extends RuntimeException {

    public BusinessExceptionHelper(String message) {
        super(message != null ? message : "Hata oluştu");
        throwThis();
    }

    private void throwThis() {
        throw this;
    }
}