package com.example.usermicroservice.service;

import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //Post
    @Transactional
    public int createUser(@NotNull @org.jetbrains.annotations.NotNull User newUser) {
        return userRepository.createUser(newUser.getUsar_name(), newUser.getPassword());
    }

    //Get all
    public ArrayList<User> getAllUsers() {
        return userRepository.findAll();
    }
    //Get by id
    public User getUserById(String username) {
       return userRepository.findUserBy(username);
    }
    //Put
    @Transactional
    public int updateUser(@NotNull @org.jetbrains.annotations.NotNull User updateOne) {
        return userRepository.updateUser(updateOne.getPassword(), updateOne.getUsar_name());
    }

    //Delete
    @Transactional
    public int deleteUser(String username) {
        int recibe = -10;
        recibe = userRepository.deleteUserBy(username);
        return recibe;
    }


}
