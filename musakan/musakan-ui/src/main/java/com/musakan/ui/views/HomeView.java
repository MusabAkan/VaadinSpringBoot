package com.musakan.ui.views;


import com.musakan.core.entities.Customer;
import com.musakan.core.service.CustomerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@Route("")
public class HomeView extends VerticalLayout {
    @Autowired
    private CustomerService customerService;

    public HomeView() {
        CustomerView();
    }

    private Grid<Customer> customerGrid;
    private TextField nameText;
    private TextField lastNameText;
    private TextField idText;

    private void CustomerView() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidthFull();
        verticalLayout.setSpacing(true);

        // Form
        FormLayout formLayout = new FormLayout();
        formLayout.setWidth("30%");

        idText = new TextField("Id");
        idText.setEnabled(false);
        formLayout.add(idText);

        nameText = new TextField("Müşteri Adı");
        formLayout.add(nameText);

        lastNameText = new TextField("Müşteri Soyadı");
        formLayout.add(lastNameText);

        // Butonlar
        Button saveButton = new Button("Kaydet");
        saveButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        saveButton.addClickListener(event -> {
            String idString = idText.getValue();
            String name = nameText.getValue();
            String lastName = lastNameText.getValue();

            if (StringUtils.isEmpty(name) || StringUtils.isEmpty(lastName)) {
                new Notification("Boş Geçilemez", 1000, Notification.Position.MIDDLE).open();
                return;
            }

            Customer customer = new Customer();
            if (!StringUtils.isEmpty(idString)) {
                customer.setId(Long.parseLong(idString));
            }
            customer.setName(name);
            customer.setLastName(lastName);

            Customer saved = customerService.save(customer);
            if (saved != null) {
                clearForm();
                new Notification("Eklenmiştir", 1000, Notification.Position.MIDDLE).open();
                fillCustomer();
            }
        });

        Button clearButton = new Button("Temizle", e -> clearForm());

        Button newButton = new Button("Yenile", e -> {
            fillCustomer();
        });
        newButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, newButton, clearButton);
        formLayout.add(buttonLayout);

        // Grid
        customerGrid = new Grid<>(Customer.class, false);
        customerGrid.setWidthFull();
        customerGrid.setHeight("400px");
        customerGrid.addColumn(Customer::getId).setHeader("ID").setSortable(true);
        customerGrid.addColumn(Customer::getName).setHeader("Ad").setSortable(true);
        customerGrid.addColumn(Customer::getLastName).setHeader("Soyad").setSortable(true);
        customerGrid.addColumn(Customer::getCreatedAt).setHeader("Oluşturma").setSortable(true);
        customerGrid.addColumn(Customer::getUpdatedAt).setHeader("Güncelleme").setSortable(true);
        customerGrid.addThemeVariants(GridVariant.LUMO_COMPACT);

        customerGrid.addItemClickListener(event -> {
            Customer customer = event.getItem();
            if (customer != null) {
                idText.setValue(customer.getId().toString());
                nameText.setValue(customer.getName());
                lastNameText.setValue(customer.getLastName());
                new Notification("Seçilen Müşteri: " + customer.getName(), 1000, Notification.Position.MIDDLE).open();
            }
        });

        // Sil Butonu
        Button deleteButton = new Button("Sil");
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        deleteButton.addClickListener(event -> {
            String idString = idText.getValue();
            if (StringUtils.isEmpty(idString)) {
                new Notification("Silinecek Müşteri Seçiniz", 1000, Notification.Position.MIDDLE).open();
                return;
            }
            customerService.delete(Long.parseLong(idString));
            clearForm();
            fillCustomer();
        });

        verticalLayout.add(formLayout, customerGrid, deleteButton);
        add(verticalLayout);

        fillCustomer();
    }

    private void clearForm() {
        idText.clear();
        nameText.clear();
        lastNameText.clear();
    }


    private void fillCustomer() {
        if (customerService != null) {
            List<Customer> customers = customerService.findAll();
            customerGrid.setItems(customers);
        }
    }
}
