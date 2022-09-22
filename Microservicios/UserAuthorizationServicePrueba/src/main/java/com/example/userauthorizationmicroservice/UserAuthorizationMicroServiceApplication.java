package com.example.userauthorizationmicroservice;

import com.example.userauthorizationmicroservice.entity.Role;
import com.example.userauthorizationmicroservice.entity.User;
import com.example.userauthorizationmicroservice.service.UserService;
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
    CommandLineRunner run (UserService userService){
        return  args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
            userService.saveRole(new Role());

            userService.saveUser(new User(null, "Andres Porras", "Andres", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Mariana Galavis", "Mariana", "1234", new ArrayList<>()));

            userService.addRoleToUser("Andres", "ROLE_USER");
            userService.addRoleToUser("Mariana", "ROLE_MANAGER");
            userService.addRoleToUser("John", "ROLE_ADMIN");

        };
    }

}
