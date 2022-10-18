package com.example.editorialmicroservice.repository;

import com.example.editorialmicroservice.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    Optional<Editorial> findByName(String name);
    boolean existsByName(String name);

}
