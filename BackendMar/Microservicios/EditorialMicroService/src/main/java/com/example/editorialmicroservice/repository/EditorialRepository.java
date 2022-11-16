package com.example.editorialmicroservice.repository;


import com.example.editorialmicroservice.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface EditorialRepository extends JpaRepository<Editorial,Integer> {
    //getAllIds
    @Query(value = "SELECT id FROM desarolloweb.editorial", nativeQuery = true)
    ArrayList<Integer> findAllId();
    //getAll
    @Query(value = "SELECT * FROM desarolloweb.editorial", nativeQuery = true)
    ArrayList<Editorial> findAll();

    //getJustOneEditorialById
    @Query(value = "SELECT * FROM desarolloweb.editorial where id=?1", nativeQuery = true)
    Editorial findEditorialById(Integer id);

    //getByName
    Editorial findAllByName(String name);

    //Put
    @Modifying
    @Query(value = "UPDATE desarolloweb.editorial SET name=?1, web_site=?2 where id=?3", nativeQuery = true)
    int updateEditorial(String nombre, String url, Integer id);

    //Patch
    //Patch name
    @Modifying
    @Query(value = "UPDATE desarolloweb.editorial SET name=?1 where id=?2", nativeQuery = true)
    int updateEditorialName(String nombre, Integer id);

    //Patch url
    @Modifying
    @Query(value = "UPDATE desarolloweb.editorial SET web_site=?1 where id=?2", nativeQuery = true)
    int updateEditorialUrl(String web_site, Integer id);

    //Patch

    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.editorial (id, name, web_site) values (?1, ?2, ?3)", nativeQuery = true)
    int createEditorial(Integer id, String nombre, String web_site);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.editorial where id=?1", nativeQuery = true)
    int deleteEditorialBy(Integer id);
}
