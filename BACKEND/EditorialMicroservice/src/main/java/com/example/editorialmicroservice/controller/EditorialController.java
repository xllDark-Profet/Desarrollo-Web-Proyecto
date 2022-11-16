package com.example.editorialmicroservice.controller;

import com.example.editorialmicroservice.dto.EditorialDto;
import com.example.editorialmicroservice.dto.Message;
import com.example.editorialmicroservice.entity.Editorial;
import com.example.editorialmicroservice.service.EditorialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/editorial")
@CrossOrigin(origins = "http://localhost:4200")
public class EditorialController {

    @Autowired
    EditorialService editorialService;

    @GetMapping("/lista")
    public ResponseEntity<List<Editorial>> list(){
        List<Editorial> list = editorialService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Editorial> getById(@PathVariable("id") int id){
        if(!editorialService.existsById(id))
            return new ResponseEntity(new Message("no existe la editorial"), HttpStatus.NOT_FOUND);
        Editorial editorial = editorialService.getOne(id).get();
        return new ResponseEntity(editorial, HttpStatus.OK);
    }

    @GetMapping("/detailname/{name}")
    public ResponseEntity<Editorial> getByName(@PathVariable("name") String name){
        if(!editorialService.existsByName(name))
            return new ResponseEntity(new Message("no existe la editorial"), HttpStatus.NOT_FOUND);
        Editorial editorial = editorialService.getByName(name).get();
        return new ResponseEntity(editorial, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EditorialDto editorialDto){
        if(StringUtils.isBlank(editorialDto.getNombre()))
            return new ResponseEntity(new Message("Ingresa un nombre"), HttpStatus.BAD_REQUEST);
        if(editorialService.existsByName(editorialDto.getNombre()))
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        Editorial editorial = new Editorial(editorialDto.getNombre(),editorialDto.getWeb_url());
        editorialService.save(editorial);
        return new ResponseEntity(new Message("Editorial creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EditorialDto editorialDto){
        if(!editorialService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        if(editorialService.existsByName(editorialDto.getNombre()) && editorialService.getByName(editorialDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(editorialDto.getNombre()))
            return new ResponseEntity(new Message("Ingrese el nombre"), HttpStatus.BAD_REQUEST);

        Editorial editorial = editorialService.getOne(id).get();
        editorial.setNombre(editorialDto.getNombre());
        editorial.setWeb_url(editorialDto.getWeb_url());

        editorialService.save(editorial);
        return new ResponseEntity(new Message("Editorial actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!editorialService.existsById(id))
            return new ResponseEntity(new Message("La Editorial no existe"), HttpStatus.NOT_FOUND);
        editorialService.delete(id);
        return new ResponseEntity(new Message("Editorial eliminada"), HttpStatus.OK);
    }


}
