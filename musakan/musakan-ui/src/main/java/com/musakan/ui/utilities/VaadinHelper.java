package com.musakan.ui.utilities;

import com.musakan.core.entities.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.server.VaadinSession;

import java.util.Optional;

public final class VaadinHelper extends UI {
    private VaadinHelper() {
    }

    public static void setCurrentUser(User user) {
        Optional.ofNullable(VaadinSession.getCurrent())
                .ifPresent(session -> session.setAttribute(User.class, user));
    }

    public static Boolean isUserLoggedIn() {
        return Optional.ofNullable(VaadinSession.getCurrent())
                .map(session -> session.getAttribute(User.class) != null)
                .orElse(false);
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
        Optional.ofNullable(getCurrent())
                .ifPresent(ui -> {
                    ui.navigate(url);
                });
    }

    public static void navigateSetCurrent(String url) {
        Optional.ofNullable(getCurrent())
                .ifPresent(ui -> {
                    ui.getPage().setLocation(url);
                });
    }

    public static void navigateRefresh() {
        Optional.ofNullable(UI.getCurrent())
                .ifPresent(ui -> {
                    ui.getPage().reload();
                });
    }

    public static void logout() {
        clearCurrentUser();
        Optional.ofNullable(VaadinSession.getCurrent())
                .ifPresent(VaadinSession::close);
        navigateTo("");
    }

    public static SideNav createSideNav(Object[][] items) {
        SideNav nav = new SideNav();
        for (Object[] item : items) {
            if (item.length == 3 && item[0] instanceof String && item[1] instanceof String && item[2] instanceof VaadinIcon) {
                nav.addItem(new SideNavItem((String) item[0], (String) item[1], ((VaadinIcon) item[2]).create()));
            }
        }
        return nav;
    }


    public static SideNavItem createSideNavItem(String title, String url, VaadinIcon icon) {
        return new SideNavItem(title, url, icon.create());
    }
}


