package com.musakan.ui.views;

import com.musakan.ui.utilities.VaadinHelper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "not-found-view")
public class NotFoundView extends VerticalLayout {
    public NotFoundView() {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        getStyle().set("background-image", "url('/images/mutlu-son.jpg')");
        getStyle().set("background-size", "75%");
        getStyle().set("background-position", "center");
        getStyle().set("background-repeat", "no-repeat");

        H2 title = new H2("404 - Sayfa Bulunamadı");
        title.getStyle().set("color", "red");

        Button navigateButton = new Button("Ana sayfaya dönmek için tıklayın");
        navigateButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        navigateButton.addClickListener(e -> VaadinHelper.navigateTo(""));

        add(title, navigateButton);


    }
}
