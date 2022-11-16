package com.example.editorialmicroservice.controller;

import com.example.editorialmicroservice.PatchEntities.PatchChangeName;
import com.example.editorialmicroservice.PatchEntities.PatchChangeWebSite;
import com.example.editorialmicroservice.entity.Editorial;
import com.example.editorialmicroservice.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/editorials")
public class EditorialController {

    @Autowired
    EditorialService editorialService;

    //POST
    @PostMapping("/editorialNewEditorial")
    private String postNewEditorial(@RequestBody Editorial newEditorial) {
        String retorno = "";
        int auxiliar = editorialService.createEditorial(newEditorial);
        if (auxiliar>0) {
            retorno = "Tu editorial fue agregada exitosamente.";
        } else {
            retorno = "Tu editorial no pudo ser agregada. Por favor verifica la información agregada.";
        }
        return retorno;
    }

    //GET
    @GetMapping("/editorial")
    private ArrayList<Editorial> getAllEditorials() {
        return editorialService.getAllEditorial();
    }

    //GET
    @GetMapping("/editorial/{idEditorial}")
    private Editorial getJustOneEditorial(@PathVariable("idEditorial") Integer id) {
        return editorialService.getEditorialById(id);
    }

    //GET by name
    @GetMapping("/editorialName/{nameEditorial}")
    private Editorial getEditorialByName(@PathVariable ("nameEditorial") String name){
        return  editorialService.getEditorialByName(name);
    }


    //PUT
    @PutMapping("/editorialUpdate")
    private String putEditorial(@RequestBody Editorial updateEditorial) {
        String retorno = "";
        int auxiliar = editorialService.updateEditorial(updateEditorial);
        if (auxiliar >0) {
            retorno = "La editorial fue modificada con éxito";
        } else {
            retorno = "No se pudo actualizar la información. Revisa los datos ingresados.";
        }
        return retorno;
    }
    //PATCH
    @PatchMapping("/changeName")
    private String patchName(@RequestBody PatchChangeName patchChangeName){
        String retorno = "";
        int auxiliar = editorialService.updateName(patchChangeName);
        if (auxiliar> 0) {
            retorno = "El nombre de tu editorial fue modificada.";
        } else {
            retorno = "No se pudo actualizar la información. Verifica la información enviada.";
        }
        return retorno;
    }
    @PatchMapping("/changeWebSite")
    private String patchWebsite(@RequestBody PatchChangeWebSite patchChangeWebSite){
        String retorno = "";
        int auxiliar = editorialService.updateWebSite(patchChangeWebSite);
        if (auxiliar >0) {
            retorno = "El website de tu editorial fue modificado con éxito.";
        } else {
            retorno = "No se pudo actualizar la información. Verifica la información enviada.";
        }
        return retorno;
    }
    //Delete
    @DeleteMapping("/editorialDelete/{idEditorial}")
    private String deleteEditorial(@PathVariable("idEditorial") Integer id) {
        int auxiliar = editorialService.deleteEditorial(id);
        String retorno = "";
        if (auxiliar >0) {
            retorno = "Se elimino exitosamente";
        } else {
            retorno = "No se eliminó la editorial. Verifica la información proporcionada o la existencia de libros asociados a la editorial";
        }
        return retorno;
    }


    //Communication with BookService

    //GET Id For BookService
    @GetMapping("/idEditorial")
    private ArrayList<Integer> getIdEditoriales(){
        return  editorialService.getIdAllEditorial();
    }


}
