package com.musakan.ui.utilities;

import com.musakan.core.entities.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;

import java.util.Optional;

public final class VaadinHelper {
    private VaadinHelper() {
    }

    public static void setCurrentUser(User user) {
        Optional.ofNullable(VaadinSession.getCurrent())
                .ifPresent(session -> session.setAttribute(User.class, user));
    }

    public static Optional<User> getCurrentUser() {
        return Optional.ofNullable(VaadinSession.getCurrent())
                .map(session -> session.getAttribute(User.class));
    }

    public static void clearCurrentUser() {
        Optional.ofNullable(VaadinSession.getCurrent())
                .ifPresent(session -> session.setAttribute(User.class, null));
    }


    public static void navigateTo(String url) {
        Optional.ofNullable(UI.getCurrent())
                .ifPresent(ui -> ui.navigate(url));
    }

    public static void logout() {
        clearCurrentUser();

        Optional.ofNullable(VaadinSession.getCurrent())
                .ifPresent(VaadinSession::close);

        navigateTo("");
    }
}
