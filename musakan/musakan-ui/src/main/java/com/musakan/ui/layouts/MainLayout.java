package com.musakan.ui.layouts;

import com.musakan.core.entities.User;
import com.musakan.ui.utilities.VaadinHelper;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.Optional;

public class MainLayout extends AppLayout implements RouterLayout {

    public MainLayout() {
        createHeader();
        addToDrawer(new SideLayout());
    }

    private void createHeader() {
        // Sol taraftaki logo ve başlık
        Icon logo = new Icon(VaadinIcon.FLAG_CHECKERED);
        logo.setColor("red");
        logo.setSize("40px");

        H2 title = new H2("Vaadin & Spring Boot Project");
        title.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.Margin.MEDIUM);

        HorizontalLayout leftSection = new HorizontalLayout(logo, title);
        leftSection.setAlignItems(Alignment.CENTER);


        MenuBar userMenu = new MenuBar();
        Optional<User> currentUser = VaadinHelper.getCurrentUser();

        MenuItem user = userMenu.addItem("👤" + currentUser.orElse(null).getCustomer());

        SubMenu subMenu = user.getSubMenu();
        subMenu.addItem("Ayarlar", e ->  VaadinHelper.navigateTo("/settings"));
        subMenu.addItem("Çıkış Yap", e ->  VaadinHelper.logout());

        // Header birleşimi
        HorizontalLayout header = new HorizontalLayout(leftSection, userMenu);
        header.setWidthFull();
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);
        header.setAlignItems(Alignment.CENTER);
        header.setPadding(true);

        addToNavbar(header);
    }
}