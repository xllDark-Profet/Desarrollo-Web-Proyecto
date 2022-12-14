package com.example.editorialmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Metodo que corre el servicio de Editorial
 */
@SpringBootApplication
@EnableEurekaClient
public class EditorialMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EditorialMicroserviceApplication.class, args);
    }

}
