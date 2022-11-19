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

/**
 * Esta clase se encarga de la logica de negocio de la aplicacion
 */
@Service
@Transactional
public class EditorialService {

    @Autowired
    EditorialRepository editorialRepository;

    /**
     * Metodo que invoca el metodo del repositorio  que regresa la lista de editoriales
     * @return lista editoriales
     */
    public List<Editorial> list(){
        return editorialRepository.findAll();
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un id devuelve una editorial
     * @param id
     * @return editorial que corresponde al id
     */
    public Optional<Editorial> getOne(int id){
        return editorialRepository.findById(id);
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un nombre devuelve una editorial
     * @param nombre
     * @return editorial que corresponde al nmbre
     */
    public Optional<Editorial> getByName(String nombre){
        return editorialRepository.findByNombre(nombre);
    }

    /**
     * Metodo que invoca el metodo del repositorio que guarda en la base de datos una editorial
     * @param editorial
     */
    public void save(Editorial editorial){
        editorialRepository.save(editorial);
    }

    /**
     * Metodo que invoca el metodo del repositorio que elimina una editorial dado un id
     * @param id
     */
    public void delete(int id){
        editorialRepository.deleteById(id);
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un id determina si la editorial existe o no en la base de datos
     * @param id
     * @return booleano que indica la existencia de la editorial correspondiente al id
     */
    public boolean existsById(int id){
        return editorialRepository.existsById(id);
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un nombre determina si la editorial existe o no en la base de datos
     * @param nombre
     * @return booleano que indica la existencia de la editorial correspondiente al nombre
     */
    public boolean existsByName(String nombre){
        return editorialRepository.existsByNombre(nombre);
    }


}
