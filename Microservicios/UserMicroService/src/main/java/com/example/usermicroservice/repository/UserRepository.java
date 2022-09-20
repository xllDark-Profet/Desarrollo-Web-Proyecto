package com.example.usermicroservice.repository;

import com.example.usermicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface UserRepository extends JpaRepository<User, String> {
    //getAllUsers
    @Query(value = "SELECT * FROm desarolloweb.user", nativeQuery = true)
    ArrayList<User> findAll();

    //getJustOneUser
    @Query(value = "select * from desarolloweb.user where usar_name=?1", nativeQuery = true)
    User findUserBy(String name);

    //Put
    @Modifying
    @Query(value = "update desarolloweb.user set password=?1 where usar_name=?2", nativeQuery = true)
    int updateUser(String password, String username);


    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.user (usar_name, password) values (?1, ?2)", nativeQuery = true)
    int createUser(String username, String password);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.user where usar_name=?1", nativeQuery = true)
    int deleteUserBy(String username);
}
