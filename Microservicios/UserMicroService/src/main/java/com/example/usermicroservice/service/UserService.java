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

    //Get all
    public ArrayList<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get by id
    public User getUserById(Integer id) {
        User userById = new User();
        userById = userRepository.findUserBy(id);
        return userById;
    }

    //Put
    @Transactional
    public int updateUser(@NotNull @org.jetbrains.annotations.NotNull User updateOne) {
        int recibe = -10;
        recibe = userRepository.updateUser(updateOne.getNombre(), updateOne.getPassword(), updateOne.getId());
        return recibe;
    }

    //Post
    @Transactional
    public int createUser(@NotNull @org.jetbrains.annotations.NotNull User newUser) {
        int recibe = -10;
        recibe =userRepository.createUser(newUser.getId(), newUser.getNombre(), newUser.getPassword());
        return recibe;
    }

    //Delete
    @Transactional
    public int deleteUser(Integer id) {
        int recibe = -10;
        recibe = userRepository.deleteUserBy(id);
        return recibe;
    }


}
