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
/**
 * Esta clase es la encargada de la logica de la aplicacion
 */
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    //Login

    /**
     * Este metodo llama al metodo en el repositorio que encuentra una persona por el nombre de usuario y contrasena en la
     * base de datos
     * @param username
     * @param password
     * @return un booleano diciendo si lo encontro o no lo encontro
     */
    public boolean findPersonLogin(String username, String password){
        boolean returnAux=false;
        if (personRepository.findPersonByUsernameAndPassword(username, password)!=null){
            returnAux=true;
        }
        return returnAux;
    }

    /**
     * Este metodo llama al metodo en el repositorio para crear una nueva persona
     * @param newPerson
     * @return resultado operacion  en la base de datos
     */
    //Post
    @Transactional
    public int createPerson(@NotNull @org.jetbrains.annotations.NotNull Person newPerson) {
        return personRepository.createPerson(newPerson.getId(), newPerson.getName(), newPerson.getSurname(), newPerson.getBirth(), newPerson.getCharge(), newPerson.getUsername(), newPerson.getPassword());
    }

    /**
     * Este metodo llama al metodo en el repositorio que encunetra a todas las personas registradas en la base de datos de
     * la libreria
     * @return lista con las personas registradas
     */
    //Get all
    public ArrayList<Person> getAllPersons() {
        return personRepository.findAll();
    }

    /**
     * Este metodo llama al metodo del repositorio que encuentra una persona dado su id
     * @param id
     * @return la persona a la que le corresponde el id
     */

    //Get by id
    public Person getPersonById(Integer id) {
       return personRepository.findPersonById(id);
    }

    /**
     * Este metodo llama al metodo del repositorio que modifica todos los atributos de una persona
     * @param updateOne
     * @return resultado operacion en la base de datos
     */
    //Put
    @Transactional
    public int updatePerson(@NotNull @org.jetbrains.annotations.NotNull Person updateOne) {
        return personRepository.updatePerson(updateOne.getName(), updateOne.getSurname(), updateOne.getBirth(), updateOne.getCharge(),  updateOne.getSurname(), updateOne.getPassword(), updateOne.getId());
    }
    //Patch

    /**
     * Este metodo llama al metodo del repositorio que modifica el atributo de nombre de la persona
     * @param patchChangeName
     * @return resultado operacion en la base de datos
     */
    @Transactional
    public int updatePersonName(@NotNull @org.jetbrains.annotations.NotNull PatchChangeName patchChangeName) {
       return personRepository.updatePersonName(patchChangeName.getName(), patchChangeName.getId());
    }

    /**
     * Este metodo llama al metodo del repositorio que modifica el atributo de apellido de la persona
     * @param patchChangeSurname
     * @return reusltado operacion en la base de datos
     */
    @Transactional
    public int updatePersonSurname(@NotNull @org.jetbrains.annotations.NotNull PatchChangeSurname patchChangeSurname) {
        return personRepository.updatePersonSurname(patchChangeSurname.getSurname(), patchChangeSurname.getId());
    }

    /**
     * Este metodo llama al metodo del repositorio que modifica el atributo de fecha de nacimiento de la persona
     * @param patchChangeBirth
     * @return reusltado operacion en la base de datos
     */
    @Transactional
    public int updatePersonBirth(@NotNull @org.jetbrains.annotations.NotNull PatchChangeBirth patchChangeBirth) {
        return personRepository.updatePersonBirth(patchChangeBirth.getBirth(), patchChangeBirth.getId());
    }

    /**
     * Este metodo llama al metodo del repositorio que modifica el atributo de rol de la persona
     * @param patchChangeCharge
     * @return resultado operacion en la base de datos
     */
    @Transactional
    public int updatePersonCharge(@NotNull @org.jetbrains.annotations.NotNull PatchChangeCharge patchChangeCharge) {
        return personRepository.updatePersonCharge(patchChangeCharge.getCharge(), patchChangeCharge.getId());
    }

    /**
     * Este metodo llama al metodo del repositorio que elimina una persona dado un id
     * @param id
     * @return resultado operacion en la base de datos
     */
    //Delete
    @Transactional
    public int deletePerson(Integer id) {
       return personRepository.deletePersonById(id);
    }


}