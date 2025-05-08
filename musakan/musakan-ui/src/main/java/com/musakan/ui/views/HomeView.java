package com.musakan.ui.views;


import com.musakan.core.entities.Customer;
import com.musakan.core.service.CustomerService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Route("")
public class HomeView extends VerticalLayout {


    @Autowired
    private CustomerService customerService;

    public HomeView() {

        VerticalLayout layout = new VerticalLayout();

        Button button = new Button("Click Me");
        button.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {

                List<Customer> all = customerService.findAll();
                for (Customer customer : all) {
                    add(new Button(customer.getCustomerName()));
                }


            }
        });
        layout.add(button);

        add(layout);


    }
}
