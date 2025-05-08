package com.musakan.ui.views;

import com.musakan.core.business.abstracts.CustomerService;
import com.musakan.core.business.concretes.CustomerManager;
import com.musakan.core.dataAccess.concretes.HibernateCustomerDao;
import com.musakan.core.entities.concretes.Customer;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {


    public HomeView() {

        VerticalLayout layout = new VerticalLayout();

        Button button = new Button("Click Me");
        button.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                CustomerService customerService = new CustomerManager(new HibernateCustomerDao());
                customerService.add(new Customer("Musab"));
            }
        });
        layout.add(button);

        add(layout);


    }
}
