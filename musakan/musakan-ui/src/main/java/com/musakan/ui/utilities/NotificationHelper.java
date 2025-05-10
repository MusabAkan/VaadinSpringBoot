package com.musakan.ui.utilities;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

/**
 * NotificationHelper sınıfı, uygulama genelinde bildirimleri yönetmek için kullanılan bir yardımcı sınıftır.
 * Farklı türlerde (hata, başarı, uyarı, bilgi) bildirimler oluşturmak için kullanılabilir.
 */
public class NotificationHelper {
    public static final int DEFAULT_DURATION = 3000;

    public enum Type {
        ERROR(NotificationVariant.LUMO_ERROR),
        SUCCESS(NotificationVariant.LUMO_SUCCESS),
        WARNING(NotificationVariant.LUMO_CONTRAST),
        INFO(NotificationVariant.LUMO_PRIMARY);

        private final NotificationVariant variant;

        Type(NotificationVariant variant) {
            this.variant = variant;
        }

        public NotificationVariant getVariant() {
            return variant;
        }
    }

    public static void show(String message, Type type, int duration) {
        Notification notification = Notification.show(message, duration, Notification.Position.MIDDLE);
        notification.addThemeVariants(type.getVariant());
    }

    public static void showError(String message) {
        show(message, Type.ERROR, DEFAULT_DURATION);
    }

    public static void showSuccess(String message) {
        show(message, Type.SUCCESS, DEFAULT_DURATION);
    }

    public static void showWarning(String message) {
        show(message, Type.WARNING, DEFAULT_DURATION);
    }

    public static void showInfo(String message) {
        show(message, Type.INFO, DEFAULT_DURATION);
    }
}