package com.musakan.ui.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Layout;

@Layout
public class MainLayout extends AppLayout {
    public MainLayout() {
        Icon flagIcon = new Icon(VaadinIcon.FLAG_CHECKERED);
        flagIcon.setColor("red");
        flagIcon.setSize("50px");

        H2 titleText = new H2("Vaadin & Sprint Boot Project");

        HorizontalLayout header = new HorizontalLayout(flagIcon, titleText);

        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        SideLayout sideLayout = new SideLayout();
        addToDrawer(sideLayout);

        addToNavbar(header);
    }
}