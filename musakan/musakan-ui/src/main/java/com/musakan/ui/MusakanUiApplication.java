package com.musakan.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.musakan")
@EnableJpaRepositories(basePackages = "com.musakan.core.dataAccess")
@EntityScan(basePackages = "com.musakan.core.entities")
@Theme("my-theme")
public class MusakanUiApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(MusakanUiApplication.class, args);
    }
}
