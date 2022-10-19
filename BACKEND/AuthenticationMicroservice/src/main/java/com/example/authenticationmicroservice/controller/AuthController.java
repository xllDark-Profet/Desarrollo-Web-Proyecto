package com.example.authenticationmicroservice.controller;

import com.example.authenticationmicroservice.dto.JWTDto;
import com.example.authenticationmicroservice.dto.LoginUserDto;
import com.example.authenticationmicroservice.dto.Message;
import com.example.authenticationmicroservice.dto.NewUserDto;
import com.example.authenticationmicroservice.entity.Rol;
import com.example.authenticationmicroservice.entity.User;
import com.example.authenticationmicroservice.enums.RolNombre;
import com.example.authenticationmicroservice.jwt.JWTProvider;
import com.example.authenticationmicroservice.service.RolService;
import com.example.authenticationmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin

public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JWTProvider jwtProvider;

    @PostMapping("/new-user")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUserDto newUserDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Campos mal ingreados"), HttpStatus.BAD_REQUEST);
        }
        if(userService.existByUserName(newUserDto.getUserName())){
            return new ResponseEntity(new Message("El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUserDto.getName(), newUserDto.getUserName(),
                passwordEncoder.encode(newUserDto.getPassword()), newUserDto.getBirth());

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if(newUserDto.getRoles().contains("admin")){
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login-user")
    public ResponseEntity<JWTDto> login(@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getUserName(), passwordEncoder.matches(loginUserDto.getPassword(), passwordEncoder.encode(loginUserDto.getPassword()))));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JWTDto jwtDto = new JWTDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
