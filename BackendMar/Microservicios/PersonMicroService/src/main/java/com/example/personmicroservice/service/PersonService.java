package com.example.personmicroservice.service;

import com.example.personmicroservice.PatchEntities.PatchChangeBirth;
import com.example.personmicroservice.PatchEntities.PatchChangeCharge;
import com.example.personmicroservice.PatchEntities.PatchChangeName;
import com.example.personmicroservice.PatchEntities.PatchChangeSurname;
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
    //Login
    public boolean findPersonLogin(String username, String password){
        boolean returnAux=false;
        if (personRepository.findPersonByUsernameAndPassword(username, password)!=null){
            returnAux=true;
        }
        return returnAux;
    }


    //Post
    @Transactional
    public int createPerson(@NotNull @org.jetbrains.annotations.NotNull Person newPerson) {
        return personRepository.createPerson(newPerson.getId(), newPerson.getName(), newPerson.getSurname(), newPerson.getBirth(), newPerson.getCharge(), newPerson.getUsername(), newPerson.getPassword());
    }

    //Get all
    public ArrayList<Person> getAllPersons() {
        return personRepository.findAll();
    }

    //Get by id
    public Person getPersonById(Integer id) {
       return personRepository.findPersonById(id);
    }

    //Put
    @Transactional
    public int updatePerson(@NotNull @org.jetbrains.annotations.NotNull Person updateOne) {
        return personRepository.updatePerson(updateOne.getName(), updateOne.getSurname(), updateOne.getBirth(), updateOne.getCharge(),  updateOne.getSurname(), updateOne.getPassword(), updateOne.getId());
    }
    //Patch
    @Transactional
    public int updatePersonName(@NotNull @org.jetbrains.annotations.NotNull PatchChangeName patchChangeName) {
       return personRepository.updatePersonName(patchChangeName.getName(), patchChangeName.getId());
    }

    @Transactional
    public int updatePersonSurname(@NotNull @org.jetbrains.annotations.NotNull PatchChangeSurname patchChangeSurname) {
        return personRepository.updatePersonSurname(patchChangeSurname.getSurname(), patchChangeSurname.getId());
    }

    @Transactional
    public int updatePersonBirth(@NotNull @org.jetbrains.annotations.NotNull PatchChangeBirth patchChangeBirth) {
        return personRepository.updatePersonBirth(patchChangeBirth.getBirth(), patchChangeBirth.getId());
    }

    @Transactional
    public int updatePersonCharge(@NotNull @org.jetbrains.annotations.NotNull PatchChangeCharge patchChangeCharge) {
        return personRepository.updatePersonCharge(patchChangeCharge.getCharge(), patchChangeCharge.getId());
    }

    //Delete
    @Transactional
    public int deletePerson(Integer id) {
       return personRepository.deletePersonById(id);
    }


}