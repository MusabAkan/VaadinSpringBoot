package com.musakan.ui.views;

import com.musakan.core.entities.Customer;
import com.musakan.core.services.CustomerService;
import com.musakan.ui.layouts.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToLongConverter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route(value = "customer-info-view", layout = MainLayout.class)
public class CustomerInfoView extends VerticalLayout {

    @Autowired
    private CustomerService customerService;

    private Grid<Customer> customerGrid;
    private TextField idText;
    private TextField nameText;
    private TextField lastNameText;

    private Binder<Customer> binder;
    private Customer selectedCustomer;

    public CustomerInfoView() {
        init();
    }

    private void init() {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidthFull();
        layout.setSpacing(true);

        FormLayout formLayout = new FormLayout();
        formLayout.setWidth("30%");

        idText = new TextField("Id");
        idText.setEnabled(false);
        nameText = new TextField("Müşteri Adı");
        lastNameText = new TextField("Müşteri Soyadı");

        formLayout.add(idText, nameText, lastNameText);


        binder = new Binder<>(Customer.class);

        binder.forField(idText)
                .withConverter(new StringToLongConverter("Geçerli bir ID giriniz"))
                .bind(Customer::getId, Customer::setId);

        binder.bind(nameText, Customer::getName, Customer::setName);
        binder.bind(lastNameText, Customer::getLastName, Customer::setLastName);

        // Butonlar
        Button saveButton = new Button("Kaydet", event -> saveCustomer());
        saveButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        Button clearButton = new Button("Temizle", event -> clearForm());

        Button refreshButton = new Button("Yenile", event -> fillCustomer());
        refreshButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, refreshButton, clearButton);
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
            selectedCustomer = event.getItem();
            binder.readBean(selectedCustomer);
            Notification.show("Seçilen Müşteri: " + selectedCustomer.getName(), 1000, Notification.Position.MIDDLE);
        });

        // Silme Butonu
        Button deleteButton = new Button("Sil", event -> deleteCustomer());
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);

        layout.add(formLayout, customerGrid, deleteButton);
        add(layout);

        fillCustomer();
    }

    private void saveCustomer() {
        if (selectedCustomer == null) {
            selectedCustomer = new Customer();
        }

        if (binder.writeBeanIfValid(selectedCustomer)) {
            Customer saved = customerService.save(selectedCustomer);
            Notification.show("Müşteri kaydedildi: " + saved.getName(), 1500, Notification.Position.MIDDLE);
            clearForm();
            fillCustomer();
        } else {
            Notification.show("Form geçerli değil!", 1000, Notification.Position.MIDDLE);
        }
    }

    private void deleteCustomer() {
        if (selectedCustomer == null || selectedCustomer.getId() == null) {
            Notification.show("Silmek için müşteri seçiniz!", 1000, Notification.Position.MIDDLE);
            return;
        }

        customerService.delete(selectedCustomer.getId());
        Notification.show("Müşteri silindi", 1000, Notification.Position.MIDDLE);
        clearForm();
        fillCustomer();
    }

    private void clearForm() {
        selectedCustomer = null;
        binder.readBean(null);
    }

    private void fillCustomer() {
        if (customerService != null) {
            List<Customer> customers = customerService.findAll();
            customerGrid.setItems(customers);
        }
    }
}