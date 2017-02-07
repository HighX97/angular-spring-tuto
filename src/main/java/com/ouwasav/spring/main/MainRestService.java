package com.ouwasav.spring.main;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.ouwasav.spring.classes.*;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ouwasav.spring.service","com.ouwasav.spring.controllers"})
public class MainRestService {

    public static void main(String[] args) {
        SpringApplication.run(MainRestService.class, args);
    }
}