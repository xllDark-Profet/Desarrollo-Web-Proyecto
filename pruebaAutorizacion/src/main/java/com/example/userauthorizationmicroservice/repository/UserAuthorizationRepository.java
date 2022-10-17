package com.example.userauthorizationmicroservice.repository;

import com.example.userauthorizationmicroservice.entity.UserAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorizationRepository extends JpaRepository<UserAuthorization, Long> {
    UserAuthorization findByUsername(String username);
}
