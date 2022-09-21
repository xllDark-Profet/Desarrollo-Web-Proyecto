package com.example.usermicroservice.service;

import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //Post
    @Transactional
    public int createUser(@NotNull @org.jetbrains.annotations.NotNull User newUser) {
        return userRepository.createUser(newUser.getUsar_name(), newUser.getPassword(), newUser.getPerson_id());
    }

    //Get all
    public ArrayList<User> getAllUsers() {
        return userRepository.findAll();
    }
    //Get by id
    public User getUserById(String username) {
        User aux= new User();
        for (User user:getAllUsers()) {
            if(user.getUsar_name().equals(username)){
                aux.setPerson_id(user.getPerson_id());
                aux.setPassword(user.getPassword());
                aux.setUsar_name(user.getUsar_name());
            }
        }
        return aux;
    }

    public Integer personUser(User user) {
       return  user.getPerson_id();
    }

    //Put
    @Transactional
    public int updateUser(@NotNull @org.jetbrains.annotations.NotNull User updateOne) {
        return userRepository.updateUserPassword(updateOne.getPassword(), updateOne.getUsar_name());
    }

    //Delete
    @Transactional
    public int deleteUser(String username) {
        int recibe = -10;
        boolean aux=false;
        recibe = userRepository.deleteUserBy(username);
        return recibe;
    }

}
