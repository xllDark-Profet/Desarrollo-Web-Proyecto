package com.example.editorialmicroservice.controller;

import com.example.editorialmicroservice.DTO.DTOChangeName;
import com.example.editorialmicroservice.DTO.DTOChangeWebSite;
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
        if (auxiliar == 1) {
            retorno = "Tu libro fue publicado";
        } else {
            retorno = "No se pudo publicar el libro";
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


    //PUT
    @PutMapping("/editorialUpdate")
    private String putEditorial(@RequestBody Editorial updateEditorial) {
        String retorno = "";
        int auxiliar = editorialService.updateEditorial(updateEditorial);
        if (auxiliar == 1) {
            retorno = "Tu libro fue modificado";
        } else {
            retorno = "No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //PATCH
    @PatchMapping("/changeName")
    private String patchName(@RequestBody DTOChangeName dtoChangeName){
        String retorno = "";
        int auxiliar = editorialService.updateName(dtoChangeName);
        if (auxiliar == 1) {
            retorno = "El nombre de tu libro fue modificado";
        } else {
            retorno = "No se pudo actualizar la informacion";
        }
        return retorno;
    }
    @PatchMapping("/changeWebSite")
    private String patchWebsite(@RequestBody DTOChangeWebSite dtoChangeWebSite){
        String retorno = "";
        int auxiliar = editorialService.updateWebSite(dtoChangeWebSite);
        if (auxiliar == 1) {
            retorno = "El website del libro fue modificado";
        } else {
            retorno = "No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Delete
    @DeleteMapping("/editorialDelete/{idEditorial}")
    private String deleteEditorial(@PathVariable("idEditorial") Integer id) {
        int auxiliar = editorialService.deleteEditorial(id);
        //ACA VA IPC PARA SABER SI SE PUEDE ELIMINAR
        String retorno = "";
        if (auxiliar == 1) {
            retorno = "Se elimino exitosamente";
        } else {
            retorno = "No se elimino";
        }
        return retorno;
    }

}
