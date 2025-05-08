package com.musakan.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.musakan")
public class MusakanUiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusakanUiApplication.class, args);
    }
}