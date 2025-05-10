package com.musakan.ui.layouts;

import com.musakan.ui.utilities.VaadinHelper;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.icon.VaadinIcon;

public class SideLayout extends AppLayout {

    public SideLayout() {
        addToDrawer(VaadinHelper.createSideNav(new Object[][]{
                {"Ana Sayfa", "/empty-view", VaadinIcon.HOME},
                {"Müşteri Hizmeti", "/customer-info-view", VaadinIcon.USER_HEART}
        }));
        setPrimarySection(Section.DRAWER);
    }
}
