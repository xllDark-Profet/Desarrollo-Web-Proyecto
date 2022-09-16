package com.example.personmicroservice.repository;

import com.example.personmicroservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface PersonRepository extends JpaRepository<Person, Integer> {
    //getAllPersons
    @Query(value = "SELECT id, nombre, apellido, fechaNacimiento, cargo FROm desarolloweb.person", nativeQuery = true)
    ArrayList<Person> findAll();

    //getJustOnePerson
    @Query(value = "select id, nombre, apellido, fechaNacimiento, cargo from desarolloweb.person where id=?1", nativeQuery = true)
    Person findPersonBy(Integer id);

    //Put
    @Modifying
    @Query(value = "update desarolloweb.person set nombre=?1, apellido=?2, fechaNacimiento=?3, cargo=?4 where id=?5", nativeQuery = true)
    int updatePerson(String nombre, String apellido, String fechaNacimiento, String cargo, Integer id);


    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.person (id, nombre, apellido, fechaNacimiento, cargo) values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    int createPerson(Integer id, String nombre, String apellido, String fechaNacimiento, String cargo);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.person where id=?1", nativeQuery = true)
    int deletePersonBy(Integer id);

}
