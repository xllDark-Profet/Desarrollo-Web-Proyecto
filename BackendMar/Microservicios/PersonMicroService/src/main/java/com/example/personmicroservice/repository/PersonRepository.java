package com.example.personmicroservice.repository;

import com.example.personmicroservice.entity.Person;
import com.example.personmicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //Get

    //getPersonByUsernameAndPassword
    Person findPersonByUsernameAndPassword(String username, String password);
    //getAllPersons
    ArrayList<Person> findAll();
    //getJustOnePerson
    Person findPersonById(Integer id);

    //Put
    @Modifying
    @Query(value = "update desarolloweb.person set name=?1, surname=?2, birth=?3, charge=?4, username=?5, password=?6 where id=?5", nativeQuery = true)
    int updatePerson(String nombre, String apellido, String fechaNacimiento, String cargo, String username, String password, Integer id);

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
    @Query(value = "insert into desarolloweb.person (id, name, surname, birth, charge, username, password) values (?1, ?2, ?3, ?4, ?5, ?6,?7)", nativeQuery = true)
    int createPerson(Integer id, String nombre, String apellido, String fechaNacimiento,String username, String password, String cargo);

    //Delete
    int deletePersonById(Integer id);

}
