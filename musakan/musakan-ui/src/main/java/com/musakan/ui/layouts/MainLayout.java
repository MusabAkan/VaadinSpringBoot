package com.musakan.ui.layouts;

import com.musakan.ui.utilities.VaadinHelper;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLayout;

public class MainLayout extends AppLayout implements RouterLayout {
    public MainLayout() {
        initLayout();
    }

    private void initLayout() {
        Button toggleDrawerButton = new Button(VaadinIcon.MENU.create());
        toggleDrawerButton.addClickListener(e -> setDrawerOpened(!isDrawerOpened()));
        toggleDrawerButton.getElement().getStyle().set("margin-right", "10px");

        // Logo ve başlık
        Icon icon = new Icon(VaadinIcon.FLAG_CHECKERED);
        icon.setColor("red");
        icon.setSize("40px");

        H2 title = new H2("Vaadin & Spring Boot Project");
        title.getStyle().set("margin", "0");

        HorizontalLayout titleSection = new HorizontalLayout(icon, title);
        titleSection.setAlignItems(FlexComponent.Alignment.CENTER);

        // Kullanıcı menüsü
        MenuBar userMenu = new MenuBar();
        if (Boolean.FALSE.equals(VaadinHelper.isUserLoggedIn())) {
            VaadinHelper.navigateTo("/not-found-view");
            VaadinHelper.navigateSetCurrent("/not-found-view");
        } else {
            MenuItem user = userMenu.addItem("👤" + VaadinHelper.getCurrentUser().orElse(null).getCustomer());
            SubMenu subMenu = user.getSubMenu();
            subMenu.addItem("Ayarlar", e -> VaadinHelper.navigateTo("/settings"));
            subMenu.addItem("Çıkış Yap", e -> VaadinHelper.logout());

            // Header birleşimi
            HorizontalLayout header = new HorizontalLayout(toggleDrawerButton, titleSection, userMenu);
            header.setWidthFull();
            header.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
            header.setAlignItems(FlexComponent.Alignment.CENTER);
            header.setPadding(true);

            addToNavbar(header);

            //todo Burrda role ekletirilecek
            addToDrawer(VaadinHelper.createSideNav(new Object[][]{
                    {"Ana Sayfa", "/empty-view", VaadinIcon.HOME},
                    {"Müşteri Hizmeti", "/customer-info-view", VaadinIcon.USER_HEART}
            }));

            // Drawer overlay olarak çalışsın, boşluk bırakmasın
            setPrimarySection(Section.NAVBAR);
            setDrawerOpened(false);
        }
    }
}
