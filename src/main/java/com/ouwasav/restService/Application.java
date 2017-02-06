package com.ouwasav.restService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//Spécifier les packages à explorer
@ComponentScan("com.ouwasav.spring.classes")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
