package com.example.personmicroservice.service;

import com.example.personmicroservice.entity.Person;
import com.example.personmicroservice.repository.PersonRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    //Get all
    public ArrayList<Person> getAllPersons() {
        return personRepository.findAll();
    }

    //Get by id
    public Person getPersonById(Integer id) {
        Person personById = new Person();
        personById = personRepository.findPersonBy(id);
        return personById;
    }

    //Put
    @Transactional
    public int updatePerson(@NotNull @org.jetbrains.annotations.NotNull Person updateOne) {
        int recibe = -10;
        recibe = personRepository.updatePerson(updateOne.getNombre(), updateOne.getApellido(), updateOne.getFechaNacimiento(), updateOne.getCargo(), updateOne.getId());
        return recibe;
    }

    //Post
    @Transactional
    public int createPerson(@NotNull @org.jetbrains.annotations.NotNull Person newPerson) {
        int recibe = -10;
        recibe = personRepository.createPerson(newPerson.getId(), newPerson.getNombre(), newPerson.getApellido(), newPerson.getFechaNacimiento(), newPerson.getCargo());
        return recibe;
    }

    //Delete
    @Transactional
    public int deletePerson(Integer id) {
        int recibe = -10;
        recibe = personRepository.deletePersonBy(id);
        return recibe;
    }
}