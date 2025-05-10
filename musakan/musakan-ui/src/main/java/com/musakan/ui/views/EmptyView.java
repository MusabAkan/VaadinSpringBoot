package com.musakan.ui.views;

import com.musakan.ui.layouts.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "empty-view", layout = MainLayout.class)
public class EmptyView extends VerticalLayout {
    public EmptyView() {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        H2 welcomeText = new H2("🎉 Hoş Geldiniz!");
        welcomeText.getStyle()
                .set("color", "#2c3e50")
                .set("font-size", "2.5rem")
                .set("margin-bottom", "0.5rem");

        Span subText = new Span("📌 Soldaki menüden seçim yapabilirsiniz.");
        subText.getStyle()
                .set("color", "#34495e")
                .set("font-size", "1.25rem");

        add(welcomeText, subText);
    }
}