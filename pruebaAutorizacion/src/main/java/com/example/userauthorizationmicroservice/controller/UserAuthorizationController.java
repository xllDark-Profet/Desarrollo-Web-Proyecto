package com.example.userauthorizationmicroservice.controller;

import com.example.userauthorizationmicroservice.entity.Role;
import com.example.userauthorizationmicroservice.entity.UserAuthorization;
import com.example.userauthorizationmicroservice.service.UserAuthorizationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/controller")
public class UserAuthorizationController {
    private final UserAuthorizationService userAuthorizationService;

    @GetMapping("/users")
    public ResponseEntity<List<UserAuthorization>> getUsers(){
        return ResponseEntity.ok().body(userAuthorizationService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserAuthorization> saveUser(@RequestBody UserAuthorization userAuthorization){
        URI uri  = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/controller/user/save").toUriString());
        return ResponseEntity.created(uri).body(userAuthorizationService.saveUser(userAuthorization));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri  = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/controller/role/save").toUriString());
        return ResponseEntity.created(uri).body(userAuthorizationService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userAuthorizationService.addRoleToUser(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }


}

@Data
class RoleToUserForm{
    private String username;
    private String rolename;
}
