package com.example.bookmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Esta clase se encarga de correr el microservicio de libros
 */
@SpringBootApplication
@EnableEurekaClient
public class BookMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMicroserviceApplication.class, args);
    }

}
