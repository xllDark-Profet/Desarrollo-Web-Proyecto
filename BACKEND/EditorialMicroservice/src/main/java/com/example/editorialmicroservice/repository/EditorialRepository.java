package com.example.editorialmicroservice.repository;

import com.example.editorialmicroservice.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Esta clase ectiende de JPA y es la encargada de realziar la comunicacion con la base de datos
 */
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    /**
     * Metodo que devuelve una editorial dado un nombre
     * @param nombre
     * @return editorial que corresponde al nombre
     */
    Optional<Editorial> findByNombre(String nombre);

    /**
     * Metodo que devuelve un booleano que indica si la editorial existe dado su nombre
     * @param nombre
     * @return booleano que indica si existe o no la editorial
     */
    boolean existsByNombre(String nombre);

}
