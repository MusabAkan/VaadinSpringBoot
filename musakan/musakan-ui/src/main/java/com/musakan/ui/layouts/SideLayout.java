package com.musakan.ui.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.sidenav.SideNav;


public class SideLayout extends AppLayout {

    public SideLayout() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("Müşteriler", "/customer-info-view", VaadinIcon.USER_HEART.create()));

        addToDrawer(nav);
        setPrimarySection(Section.DRAWER);
    }
}
