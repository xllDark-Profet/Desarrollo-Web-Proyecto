package com.example.userauthorizationmicroservice.service;

import com.example.userauthorizationmicroservice.entity.Role;
import com.example.userauthorizationmicroservice.entity.UserAuthorization;
import com.example.userauthorizationmicroservice.repository.RoleRepository;
import com.example.userauthorizationmicroservice.repository.UserAuthorizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserAuthorizationService, UserDetailsService {

    private final UserAuthorizationRepository userAuthorizationRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthorization userAuthorization = userAuthorizationRepository.findByUsername(username);
        if(userAuthorization == null){
            log.error("Usuario no encontrado en la base de datos.");
            throw new UsernameNotFoundException("Usuario no encontrado en la base de datos");
        } else{
            log.info("Usuario encontrado en la base de datos");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userAuthorization.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(userAuthorization.getUsername(), userAuthorization.getPassword(), authorities);
    }

    @Override
    public UserAuthorization saveUser(UserAuthorization userAuthorization) {
        log.info("Guardando nuevo usuario {} en la base de datos", userAuthorization.getName());
        userAuthorization.setPassword(passwordEncoder.encode(userAuthorization.getPassword()));
        return userAuthorizationRepository.save(userAuthorization);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Guardando nuevo rol {} en la base de datos", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("Agregando rol {} al usuario {} ", rolename, username);
        UserAuthorization userAuthorization = userAuthorizationRepository.findByUsername(username);
        Role role = roleRepository.findByName(rolename);
        userAuthorization.getRoles().add(role);
    }

    @Override
    public UserAuthorization getUser(String username) {
        log.info("Listando usuario {}", username);
        return userAuthorizationRepository.findByUsername(username);
    }

    @Override
    public List<UserAuthorization> getUsers() {
        log.info("Listando todos los usuarios ");
        return userAuthorizationRepository.findAll();
    }


}
