package com.example.editorialmicroservice.repository;


import com.example.editorialmicroservice.entity.Editorial;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface EditorialRepository {
    //getAll
    @Query(value = "SELECT id, nombre, url FROm desarolloweb.editorial", nativeQuery = true)
    ArrayList<Editorial> findAll();

    //getJustOneEditorial
    @Query(value = "select id, nombre, url from desarolloweb.editorial where id=?1", nativeQuery = true)
    Editorial findEditorialBy(Integer id);

    //Put
    @Modifying
    @Query(value = "update desarolloweb.editorial set nombre=?1, url=?2 where id=?3", nativeQuery = true)
    int updateEditorial(String nombre, String url, Integer id);


    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.editorial (id, nombre, url) values (?1, ?2, ?3)", nativeQuery = true)
    int createEditorial(Integer id, String nombre, String url);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.editorial where id=?1", nativeQuery = true)
    int deleteEditorialBy(Integer id);
}
