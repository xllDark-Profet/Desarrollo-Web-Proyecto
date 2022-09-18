package com.example.personmicroservice.service;

import com.example.personmicroservice.DTO.DTOChangeBirth;
import com.example.personmicroservice.DTO.DTOChangeCharge;
import com.example.personmicroservice.DTO.DTOChangeName;
import com.example.personmicroservice.DTO.DTOChangeSurname;
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

    //Post
    @Transactional
    public int createPerson(@NotNull @org.jetbrains.annotations.NotNull Person newPerson) {
        return personRepository.createPerson(newPerson.getId(), newPerson.getName(), newPerson.getSurname(), newPerson.getBirth(), newPerson.getCharge());
    }

    //Get all
    public ArrayList<Person> getAllPersons() {
        return personRepository.findAll();
    }

    //Get by id
    public Person getPersonById(Integer id) {
       return personRepository.findPersonBy(id);
    }

    //Put
    @Transactional
    public int updatePerson(@NotNull @org.jetbrains.annotations.NotNull Person updateOne) {
        return personRepository.updatePerson(updateOne.getName(), updateOne.getSurname(), updateOne.getBirth(), updateOne.getCharge(), updateOne.getId());
    }
    //Patch
    @Transactional
    public int updatePersonName(@NotNull @org.jetbrains.annotations.NotNull DTOChangeName dtoChangeName) {
       return personRepository.updatePersonName(dtoChangeName.getName(), dtoChangeName.getId());
    }

    @Transactional
    public int updatePersonSurname(@NotNull @org.jetbrains.annotations.NotNull DTOChangeSurname dtoChangeSurname) {
        return personRepository.updatePersonSurname(dtoChangeSurname.getSurname(), dtoChangeSurname.getId());
    }

    @Transactional
    public int updatePersonBirth(@NotNull @org.jetbrains.annotations.NotNull DTOChangeBirth dtoChangeBirth) {
        return personRepository.updatePersonBirth(dtoChangeBirth.getBirth(), dtoChangeBirth.getId());
    }

    @Transactional
    public int updatePersonCharge(@NotNull @org.jetbrains.annotations.NotNull DTOChangeCharge dtoChangeCharge) {
        return personRepository.updatePersonCharge(dtoChangeCharge.getCharge(), dtoChangeCharge.getId());
    }

    //Delete
    @Transactional
    public int deletePerson(Integer id) {
       return personRepository.deletePersonBy(id);
    }
}