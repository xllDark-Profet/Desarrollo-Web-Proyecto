package com.example.usermicroservice.repository;

import com.example.usermicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface UserRepository extends JpaRepository<User, Integer> {
    //getAllUsers
    @Query(value = "SELECT id, nombre, password FROm desarolloweb.user", nativeQuery = true)
    ArrayList<User> findAll();

    //getJustOneUser
    @Query(value = "select id, nombre, password from desarolloweb.user where id=?1", nativeQuery = true)
    User findUserBy(Integer id);

    //Put
    @Modifying
    @Query(value = "update desarolloweb.user set nombre=?1, password=?2 where id=?3", nativeQuery = true)
    int updateUser(String nombre, String password, Integer id);


    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.user (id, nombre, password) values (?1, ?2, ?3)", nativeQuery = true)
    int createUser(Integer id, String nombre, String password);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.user where id=?1", nativeQuery = true)
    int deleteUserBy(Integer id);
}
