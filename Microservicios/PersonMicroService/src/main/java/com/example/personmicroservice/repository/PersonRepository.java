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
    @Query(value = "SELECT * FROm desarolloweb.person", nativeQuery = true)
    ArrayList<Person> findAll();

    //getJustOnePerson
    @Query(value = "select * from desarolloweb.person where id=?1", nativeQuery = true)
    Person findPersonBy(Integer id);

    //Put
    @Modifying
    @Query(value = "update desarolloweb.person set name=?1, surname=?2, birth=?3, charge=?4 where id=?5", nativeQuery = true)
    int updatePerson(String nombre, String apellido, String fechaNacimiento, String cargo, Integer id);

    //Patch
    //Change name
    @Modifying
    @Query(value="update desarolloweb.person set name=?1 where id=?2", nativeQuery = true)
    int updatePersonName(String name, Integer id);

    //Change surname
    @Modifying
    @Query(value="update desarolloweb.person set surname=?1 where id=?2", nativeQuery = true)
    int updatePersonSurname(String surname, Integer id);

    //Change birth
    @Modifying
    @Query(value="update desarolloweb.person set birth=?1 where id=?2", nativeQuery = true)
    int updatePersonBirth(String birth, Integer id);

    //Change charge
    @Modifying
    @Query(value="update desarolloweb.person set charge=?1 where id=?2", nativeQuery = true)
    int updatePersonCharge(String charge, Integer id);

    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.person (id, name, surname, birth, charge) values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    int createPerson(Integer id, String nombre, String apellido, String fechaNacimiento, String cargo);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.person where id=?1", nativeQuery = true)
    int deletePersonBy(Integer id);

}
