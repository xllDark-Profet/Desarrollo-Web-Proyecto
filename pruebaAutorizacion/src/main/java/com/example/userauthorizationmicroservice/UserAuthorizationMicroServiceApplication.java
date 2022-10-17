package com.example.userauthorizationmicroservice;

import com.example.userauthorizationmicroservice.entity.Role;
import com.example.userauthorizationmicroservice.entity.UserAuthorization;
import com.example.userauthorizationmicroservice.service.UserAuthorizationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserAuthorizationMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthorizationMicroServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

    @Bean
    CommandLineRunner run (UserAuthorizationService userAuthorizationService){
        return  args -> {
            userAuthorizationService.saveRole(new Role(null, "ROLE_USER"));
            userAuthorizationService.saveRole(new Role(null, "ROLE_MANAGER"));
            userAuthorizationService.saveRole(new Role(null, "ROLE_ADMIN"));
            userAuthorizationService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
            userAuthorizationService.saveRole(new Role());

            userAuthorizationService.saveUser(new UserAuthorization(null, "Andres Porras", "Andres", "1234", new ArrayList<>()));
            userAuthorizationService.saveUser(new UserAuthorization(null, "Mariana Galavis", "Mariana", "1234", new ArrayList<>()));

            userAuthorizationService.addRoleToUser("Andres", "ROLE_USER");
            userAuthorizationService.addRoleToUser("Mariana", "ROLE_MANAGER");
            userAuthorizationService.addRoleToUser("John", "ROLE_ADMIN");

        };
    }

}
