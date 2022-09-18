package com.example.editorialmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EditorialMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EditorialMicroServiceApplication.class, args);
    }

}
