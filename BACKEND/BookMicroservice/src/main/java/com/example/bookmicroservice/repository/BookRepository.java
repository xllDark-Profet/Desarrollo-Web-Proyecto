package com.example.bookmicroservice.repository;

import com.example.bookmicroservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository  extends PagingAndSortingRepository<Book, Integer>, QueryByExampleExecutor<Book> {
    Optional<Book> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
