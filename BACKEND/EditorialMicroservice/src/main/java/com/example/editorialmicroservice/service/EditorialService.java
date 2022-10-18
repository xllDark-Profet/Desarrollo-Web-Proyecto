package com.example.editorialmicroservice.service;

import com.example.editorialmicroservice.entity.Editorial;
import com.example.editorialmicroservice.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EditorialService {

    @Autowired
    EditorialRepository editorialRepository;

    public List<Editorial> list(){
        return editorialRepository.findAll();
    }

    public Optional<Editorial> getOne(int id){
        return editorialRepository.findById(id);
    }

    public Optional<Editorial> getByName(String name){
        return editorialRepository.findByName(name);
    }

    public void save(Editorial editorial){
        editorialRepository.save(editorial);
    }

    public void delete(int id){
        editorialRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return editorialRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return editorialRepository.existsByName(name);
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

    public List<Editorial> getIdAllEditorial(List<Integer> ids){
        List<Editorial> editorialsid = (List<Editorial>) editorialRepository.findAllById(ids);
        return editorialsid;
    }


}
