package com.example.authenticationmicroservice.repository;

import com.example.authenticationmicroservice.entity.Rol;
import com.example.authenticationmicroservice.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
