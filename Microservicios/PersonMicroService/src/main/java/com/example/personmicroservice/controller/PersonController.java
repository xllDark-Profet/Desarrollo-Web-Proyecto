package com.example.personmicroservice.controller;


import com.example.personmicroservice.entity.Person;
import com.example.personmicroservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    //POST
    @PostMapping("/personNewPerson")
    private String postNewPerson(@RequestBody Person newPerson) {
        String retorno = "";
        int auxiliar = personService.createPerson(newPerson);
        if (auxiliar == 1) {
            retorno = "Tu libro fue publicado";
        } else {
            retorno = "No se pudo publicar el libro";
        }
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
        int auxiliar = personService.updatePerson(updatePerson);
        if (auxiliar == 1) {
            retorno = "Tu libro fue modificado";
        } else {
            retorno = "No se pudo actualizar la informacion";
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
