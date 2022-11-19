package com.example.bookmicroservice.repository;

import com.example.bookmicroservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Clase que extiende del repositorio de JPA y que sera la encargada de realizar las diferentes
 * interacciones con la base de datos.
 */
@Repository
public interface BookRepository  extends PagingAndSortingRepository<Book, Integer>, QueryByExampleExecutor<Book> {

    Optional<Book> findByNombre(String nombre);

    /**
     * Metodo que devuelve un booleano indicando si el libro existe o no
     * @param nombre
     * @return
     */
    boolean existsByNombre(String nombre);
}
