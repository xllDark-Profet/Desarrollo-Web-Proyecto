package com.example.personmicroservice.controller;


import com.example.personmicroservice.DTO.DTOChangeBirth;
import com.example.personmicroservice.DTO.DTOChangeCharge;
import com.example.personmicroservice.DTO.DTOChangeName;
import com.example.personmicroservice.DTO.DTOChangeSurname;
import com.example.personmicroservice.entity.Person;
import com.example.personmicroservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    //POST
    @PostMapping("/personNewPerson")
    private String postNewPerson(@RequestBody Person newPerson) {
        String retorno = "";
        if (newPerson.getName()==null || newPerson.getId()==null|| newPerson.getSurname()==null||
        newPerson.getBirth()==null|| newPerson.getCharge()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if (personService.createPerson(newPerson)!=1) {
            retorno="No se pudo crear.";
        }
        else{retorno="Se ha creado exitosamente";}
        return retorno;
    }

    //GET
    @GetMapping("/person")
    private ArrayList<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    //GET
    @GetMapping("/person/{idPerson}")
    private Person getJustOnePerson(@PathVariable("idPerson") Integer id) {
        return personService.getPersonById(id);
    }

    //PUT
    @PutMapping("/personUpdate")
    private String putPerson(@RequestBody Person updatePerson) {
        String retorno = "";
        if (updatePerson.getName()==null || updatePerson.getId()==null|| updatePerson.getSurname()==null||
                updatePerson.getBirth()==null||updatePerson.getCharge()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePerson(updatePerson)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }

        return retorno;
    }

    //PATCH
    //Name
    @PatchMapping("/changeName")
    private String patchPersonName(@RequestBody DTOChangeName dtoChangeName) {
        String retorno = "";
        if (dtoChangeName.getName()==null||dtoChangeName.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonName(dtoChangeName)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Surname
    @PatchMapping("/changeSurname")
    private String patchPersonSurname(@RequestBody DTOChangeSurname dtoChangeSurname) {
        String retorno = "";
        if (dtoChangeSurname.getSurname()==null||dtoChangeSurname.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonSurname(dtoChangeSurname)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Birth
    @PatchMapping("/changeBirth")
    private String patchPersonBirth(@RequestBody DTOChangeBirth dtoChangeBirth) {
        String retorno = "";
        if (dtoChangeBirth.getBirth()==null||dtoChangeBirth.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonBirth(dtoChangeBirth)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Charge
    @PatchMapping("/changeCharge")
    private String patchPersonCharge(@RequestBody DTOChangeCharge dtoChangeCharge) {
        String retorno = "";
        if (dtoChangeCharge.getCharge()==null||dtoChangeCharge.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonCharge(dtoChangeCharge)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Delete
    @DeleteMapping("/personDelete/{idPerson}")
    private String deletePerson(@PathVariable("idPerson") Integer id) {
        int auxiliar = personService.deletePerson(id);
        String retorno = "";
        if (auxiliar == 1) {
            retorno = "Se elimino exitosamente";
        } else {
            retorno = "No se elimino";
        }
        return retorno;
    }

}
