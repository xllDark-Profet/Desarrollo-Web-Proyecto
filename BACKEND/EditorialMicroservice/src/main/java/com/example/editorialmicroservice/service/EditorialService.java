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

    public Optional<Editorial> getByName(String nombre){
        return editorialRepository.findByNombre(nombre);
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

    public boolean existsByName(String nombre){
        return editorialRepository.existsByNombre(nombre);
    }


}
