package com.musakan.ui.utilities;


import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class NotificationHelper {

    public static void showError(String message) {
        Notification.show(message, 3000, Notification.Position.MIDDLE)
                .addThemeVariants(NotificationVariant.LUMO_ERROR);
    }

    public static void showSuccess(String message) {
        Notification.show(message, 2000, Notification.Position.MIDDLE)
                .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

    public static void showWarning(String message) {
        Notification.show(message, 2000, Notification.Position.MIDDLE)
                .addThemeVariants(NotificationVariant.LUMO_CONTRAST);
    }

    public static void showInfo(String message) {
        Notification.show(message, 2000, Notification.Position.MIDDLE)
                .addThemeVariants(NotificationVariant.LUMO_PRIMARY);
    }
}