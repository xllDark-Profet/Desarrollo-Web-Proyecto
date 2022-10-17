package com.example.userauthorizationmicroservice.service;

import com.example.userauthorizationmicroservice.entity.Role;
import com.example.userauthorizationmicroservice.entity.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();
}
