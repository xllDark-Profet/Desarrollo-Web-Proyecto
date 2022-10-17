package com.example.userauthorizationmicroservice.repository;

import com.example.userauthorizationmicroservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
