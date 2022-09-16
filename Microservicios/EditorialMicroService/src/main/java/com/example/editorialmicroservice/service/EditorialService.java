package com.example.editorialmicroservice.service;

import com.example.editorialmicroservice.entity.Editorial;
import com.example.editorialmicroservice.repository.EditorialRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class EditorialService {
    @Autowired
    EditorialRepository editorialRepository;

    //Get all
    public ArrayList<Editorial> getAllEditorial() {
        return editorialRepository.findAll();
    }

    //Get by id
    public Editorial getEditorialById(Integer id) {
        Editorial editorialById = new Editorial();
        editorialById = editorialRepository.findEditorialBy(id);
        return editorialById;
    }


    //Put
    @Transactional
    public int updateEditorial(@NotNull @org.jetbrains.annotations.NotNull Editorial updateOne) {
        int recibe = -10;
        recibe = editorialRepository.updateEditorial(updateOne.getNombre(), updateOne.getUrl(), updateOne.getId());
        return recibe;
    }

    //Post
    @Transactional
    public int createEditorial(@NotNull @org.jetbrains.annotations.NotNull Editorial newUser) {
        int recibe = -10;
        recibe =editorialRepository.createEditorial(newUser.getId(), newUser.getNombre(), newUser.getUrl());
        return recibe;
    }

    //Delete
    @Transactional
    public int deleteEditorial(Integer id) {
        int recibe = -10;
        recibe = editorialRepository.deleteEditorialBy(id);
        return recibe;
    }
}
