package com.example.usermicroservice.controller;

import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //POST
    @PostMapping("/userNewUser")
    private String postNewUser(@RequestBody User newUser) {
        String retorno = "";
        int auxiliar = userService.createUser(newUser);
        if (auxiliar == 1) {
            retorno = "Tu libro fue publicado";
        } else {
            retorno = "No se pudo publicar el libro";
        }
        return retorno;
    }

    //GET
    @GetMapping("/user")
    private ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //GET
    @GetMapping("/user/{idUser}")
    private User getJustOneUser(@PathVariable("idUser") String id) {
        return userService.getUserById(id);
    }


    //PUT
    @PutMapping("/userUpdate")
    private String putUser(@RequestBody User updateUser) {
        String retorno = "";
        int auxiliar = userService.updateUser(updateUser);
        if (auxiliar == 1) {
            retorno = "Tu libro fue modificado";
        } else {
            retorno = "No se pudo actualizar la informacion";
        }
        return retorno;
    }

    //Delete
    @DeleteMapping("/userDelete/{idUser}")
    private String deleteUser(@PathVariable("idUser") String username) {
        int auxiliar = userService.deleteUser(username);
        String retorno = "";
        if (auxiliar == 1) {
            retorno = "Se elimino exitosamente";
        } else {
            retorno = "No se elimino";
        }
        return retorno;
    }
}
