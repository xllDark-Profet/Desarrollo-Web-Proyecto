package com.example.authenticationmicroservice.service;

import com.example.authenticationmicroservice.entity.User;
import com.example.authenticationmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> list(){
        return userRepository.findAll();
    }

    public Optional<User> getByUserName(String userName){
        return userRepository.findUserByUsername(userName);
    }

    public boolean existByUserName(String userName){
        return userRepository.existsByUsername(userName);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
