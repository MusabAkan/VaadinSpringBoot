package com.musakan.ui.views;

import com.musakan.core.dtos.UserDto;
import com.musakan.core.entities.User;
import com.musakan.core.services.UserService;
import com.musakan.core.utilities.BinderHelper;
import com.musakan.ui.utilities.NotificationHelper;
import com.musakan.ui.utilities.VaadinHelper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "")
public class LoginView extends VerticalLayout {

    @Autowired
    private UserService userService;

    public LoginView(UserService userService) {
        this.userService = userService;
        init();
    }

    private void init() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        Binder<UserDto> loginBinder = new Binder<>(UserDto.class);

        EmailField emailField = new EmailField("E-posta");
        emailField.setRequired(true);
        emailField.setWidth("400px");
        emailField.getElement().getStyle().set("font-size", "16px");
        BinderHelper.bindWithValidation(loginBinder, emailField, UserDto::getEmail, UserDto::setEmail, "E-posta gerekli");

        PasswordField passwordField = new PasswordField("Şifre");
        passwordField.setRequired(true);
        passwordField.setWidth("400px");
        passwordField.getElement().getStyle().set("font-size", "16px");
        BinderHelper.bindWithValidation(loginBinder, passwordField, UserDto::getPassword, UserDto::setPassword, "Şifre gerekli");

        Button loginButton = new Button("Giriş Yap", VaadinIcon.SIGN_IN.create());
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        loginButton.addClickListener(e -> {
            login(loginBinder);
        });

        Button registerButton = new Button("Yeni kullanıcı oluştur", VaadinIcon.USER.create());
        registerButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        registerButton.addClickListener(e -> openShowDialogByRegister());

        VerticalLayout formLayout = new VerticalLayout(emailField, passwordField, loginButton, registerButton);
        formLayout.setSpacing(true);
        formLayout.setWidth("300px");

        add(formLayout);
    }

    private void login(Binder<UserDto> loginBinder) {
        UserDto userDto = new UserDto();
        if (loginBinder.writeBeanIfValid(userDto)) {
            User user = userService.login(userDto);

            VaadinHelper.setCurrentUser(user);
            VaadinHelper.navigateTo("empty-view");

            NotificationHelper.showSuccess("Giriş başarılı");
        }
    }

    private void openShowDialogByRegister() {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Yeni Kullanıcı Oluştur");

        Binder<UserDto> binder = new Binder<>(UserDto.class);

        TextField firstName = new TextField("Ad");
        firstName.setRequired(true);
        BinderHelper.bindWithValidation(binder, firstName, UserDto::getFirstName, UserDto::setFirstName, "Ad gerekli");

        TextField lastName = new TextField("Soyad");
        lastName.setRequired(true);
        BinderHelper.bindWithValidation(binder, lastName, UserDto::getLastName, UserDto::setLastName, "Soyad gerekli");

        EmailField email = new EmailField("E-posta");
        email.setRequired(true);
        BinderHelper.bindWithValidation(binder, email, UserDto::getEmail, UserDto::setEmail, "E-posta gerekli");

        PasswordField password = new PasswordField("Şifre");
        password.setRequired(true);
        BinderHelper.bindWithValidation(binder, password, UserDto::getPassword, UserDto::setPassword, "Şifre gerekli");

        DatePicker birthDate = new DatePicker("Doğum Tarihi");
        BinderHelper.bindWithValidation(binder, birthDate, UserDto::getBirthDate, UserDto::setBirthDate);

        TextField phoneNumber = new TextField("Telefon");
        BinderHelper.bindWithValidation(binder, phoneNumber, UserDto::getPhoneNumber, UserDto::setPhoneNumber);

        FormLayout formLayout = new FormLayout(firstName, lastName, email, password, birthDate, phoneNumber);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 2)
        );
        formLayout.setColspan(email, 2);

        Button saveButton = new Button("Kaydet", e -> save(binder, dialog));
        Button cancelButton = new Button("İptal", e -> dialog.close());
        dialog.getFooter().add(cancelButton, saveButton);

        dialog.add(formLayout);
        dialog.open();
    }

    private void save(Binder<UserDto> binder, Dialog dialog) {
        UserDto userDto = new UserDto();
        if (binder.writeBeanIfValid(userDto)) {
            userService.register(userDto);
            NotificationHelper.showSuccess("Kullanıcı başarıyla oluşturuldu");
            dialog.close();
        }
    }
}
