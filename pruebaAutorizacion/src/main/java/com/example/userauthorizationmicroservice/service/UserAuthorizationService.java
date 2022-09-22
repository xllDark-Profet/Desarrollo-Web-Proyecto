package com.example.userauthorizationmicroservice.service;

import com.example.userauthorizationmicroservice.entity.Role;
import com.example.userauthorizationmicroservice.entity.UserAuthorization;

import java.util.List;

public interface UserAuthorizationService {
    UserAuthorization saveUser(UserAuthorization userAuthorization);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    UserAuthorization getUser(String username);
    List<UserAuthorization> getUsers();
}
