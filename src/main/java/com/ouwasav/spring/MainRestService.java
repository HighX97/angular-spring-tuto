package com.ouwasav.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*
@ComponentScan(basePackages = {
		"com.ouwasav.spring.repository",
		"com.ouwasav.spring.service",
		"com.ouwasav.spring.controllers"})
		*/
public class MainRestService {

    public static void main(String[] args) {
        SpringApplication.run(MainRestService.class, args);
    }
}