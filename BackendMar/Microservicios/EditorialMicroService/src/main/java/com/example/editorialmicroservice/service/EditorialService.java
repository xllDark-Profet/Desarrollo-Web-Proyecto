package com.example.editorialmicroservice.service;

import com.example.editorialmicroservice.PatchEntities.PatchChangeName;
import com.example.editorialmicroservice.PatchEntities.PatchChangeWebSite;
import com.example.editorialmicroservice.entity.Editorial;
import com.example.editorialmicroservice.repository.EditorialRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class EditorialService {
    @Autowired
    EditorialRepository editorialRepository;

    //Post
    @Transactional
    public int createEditorial(@NotNull @org.jetbrains.annotations.NotNull Editorial newUser) {
        int recibe = -10;
        recibe =editorialRepository.createEditorial(newUser.getId(), newUser.getNombre(), newUser.getUrl());
        return recibe;
    }

    //Get all
    public ArrayList<Editorial> getAllEditorial() {
        return editorialRepository.findAll();
    }

    //Get by id
    public Editorial getEditorialById(Integer id) {
        Editorial editorialById = new Editorial();
        editorialById = editorialRepository.findEditorialById(id);
        return editorialById;
    }

    //Get by Name
    public Editorial getEditorialByName(String Name){
        return  editorialRepository.findAllByName(Name);
    }
    //Put
    @Transactional
    public int updateEditorial(@NotNull @org.jetbrains.annotations.NotNull Editorial updateOne) {
        int recibe = -10;
        recibe = editorialRepository.updateEditorial(updateOne.getNombre(), updateOne.getUrl(), updateOne.getId());
        return recibe;
    }

    @Transactional
    public int updateName(@NotNull PatchChangeName patchChangeName){
        int recibe=-10;
        recibe=editorialRepository.updateEditorialName(patchChangeName.getName(), patchChangeName.getId());
        return recibe;
    }

    @Transactional
    public int updateWebSite(@org.jetbrains.annotations.NotNull PatchChangeWebSite patchChangeWebSite){
        int recibe=-10;
        System.out.println(patchChangeWebSite.getId()+ "  y  "+ patchChangeWebSite.getWebsite());
        recibe=editorialRepository.updateEditorialUrl(patchChangeWebSite.getWebsite(), patchChangeWebSite.getId());
        return recibe;
    }

    //Delete
    @Transactional
    public int deleteEditorial(Integer id) {
        int recibe = -10;
        Boolean result=true;
        result=editorialInventoryBooks(id);
        if(result==false){
            recibe = editorialRepository.deleteEditorialBy(id);
        }
        return recibe;
    }


    //Communication with BookService
    //Books By Editorial
    public Boolean editorialInventoryBooks(Integer idEditorial) {
        Boolean result = false;
        ArrayList<Integer> ids = new RestTemplate().getForObject("http://localhost:8081/books/getUseId", ArrayList.class);
        for (Integer inte : ids) {
            if (inte == idEditorial) {
                result = true;
            }
        }
        return result;
    }

    public ArrayList<Integer> getIdAllEditorial() {
        return editorialRepository.findAllId();
    }




}
