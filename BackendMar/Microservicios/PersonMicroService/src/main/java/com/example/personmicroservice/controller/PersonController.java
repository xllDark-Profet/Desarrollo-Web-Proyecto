package com.example.personmicroservice.controller;


import com.example.personmicroservice.PatchEntities.PatchChangeBirth;
import com.example.personmicroservice.PatchEntities.PatchChangeCharge;
import com.example.personmicroservice.PatchEntities.PatchChangeName;
import com.example.personmicroservice.PatchEntities.PatchChangeSurname;
import com.example.personmicroservice.entity.Person;
import com.example.personmicroservice.entity.User;
import com.example.personmicroservice.service.PersonService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta clase se encarga de la comunicacion REST
 */
@RestController
@CrossOrigin()
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    /**
     * Metodo para autenticar un usuario  llamado login
     * @param userLogin
     * @return el objeto usuario con la con el token y la respuesta http
     */

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User userLogin) {

        if (personService.findPersonLogin(userLogin.getUsername(), userLogin.getPassword())==true) {
            String token = getJWTToken(userLogin.getUsername());
            User user = new User();
            user.setUsername(userLogin.getUsername());
            user.setPassword(token);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else{
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Metodo que usa JWT para generar el token de autenticacion
     * @param username
     * @return token
     */
    public String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    /**
     * Metodo para crear un nuevo usuario en la base de datos. Este metodo revisa que los campos esten llenos
     * y posteriormente procede a realizar el llamado al servicio que permitira la creacion.
     * @param newPerson
     * @return cadena que representa el resultado de la operacion
     */
    //POST
    @PostMapping("/personNewPerson")
    private ResponseEntity<String> postNewPerson(@RequestBody Person newPerson) {
        String retorno = "";
        if (newPerson.getName()==null || newPerson.getId()==null|| newPerson.getSurname()==null||
        newPerson.getBirth()==null|| newPerson.getCharge()==null){
            retorno="Hay campos obligatorios que no ha llenado";
            return new ResponseEntity<>(retorno, HttpStatus.BAD_REQUEST);
        } else if (personService.createPerson(newPerson)!=1) {
            retorno="No se pudo crear.";
            return new ResponseEntity<>(retorno, HttpStatus.BAD_REQUEST);
        }
        else{retorno="Se ha creado exitosamente";
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }

    }

    /**
     * Metodo para obtener todos los usuarios de la base de datos.
     * @param
     * @return lista de personas que registradas en la libreria
     */
    //GET
    @GetMapping("/lista")
    private ResponseEntity<List<Person>> getAllPersons() {
        List<Person> list = personService.getAllPersons();
        return new ResponseEntity(list, HttpStatus.OK);

    }
    /**
     * Metodo para buscar un usuario teniendo su id
     * @param id
     * @return persona en especifico
     */
    //GET
    @GetMapping("/person/{idPerson}")
    private Person getJustOnePerson(@PathVariable("idPerson") Integer id) {
        return personService.getPersonById(id);
    }
    /**
     * Metodo modificar TODA la informacion de un usuario. En primer lugar se encarga de revisar que los campos no
     * esten vacios. Una vez verificado, llama a la funcion del servicio que permitira ejecutar la funcionalidad.
     * @param updatePerson
     * @return cadena que representa el resultado de la operacion
     */
    //PUT
    @PutMapping("/personUpdate")
    private String putPerson(@RequestBody Person updatePerson) {
        String retorno = "";
        if (updatePerson.getName()==null || updatePerson.getId()==null|| updatePerson.getSurname()==null||
                updatePerson.getBirth()==null||updatePerson.getCharge()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePerson(updatePerson)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }

        return retorno;
    }

    //PATCH
    //Name
    /**
     * Metodo para modificar solo el nombre de la persona. En primer lugar revisa que los campos no esten vacios y posteriormente
     * realiza el llamado al metodo del servicio que permite ejecturar la funcionalidad
     * @param patchChangeName
     * @return cadena que representa el resultado de la operacion
     */
    @PatchMapping("/changeName")
    private String patchPersonName(@RequestBody PatchChangeName patchChangeName) {
        String retorno = "";
        if (patchChangeName.getName()==null|| patchChangeName.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonName(patchChangeName)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Surname
    /**
     * Metodo para modificar solo el apellido de la persona.  En primer lugar revisa que los campos no esten vacios y posteriormente
     *      * realiza el llamado al metodo del servicio que permite ejecturar la funcionalidad
     * @param patchChangeSurname
     * @return cadena que representa el resultado de la operacion
     */
    @PatchMapping("/changeSurname")
    private String patchPersonSurname(@RequestBody PatchChangeSurname patchChangeSurname) {
        String retorno = "";
        if (patchChangeSurname.getSurname()==null|| patchChangeSurname.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonSurname(patchChangeSurname)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Birth
    /**
     * Metodo para modificar solo la fecha de nacimiento de la persona. En primer lugar revisa que los campos no esten vacios y posteriormente
     *      * realiza el llamado al metodo del servicio que permite ejecturar la funcionalidad
     * @param patchChangeBirth
     * @return cadena que representa el resultado de la operacion
     */
    @PatchMapping("/changeBirth")
    private String patchPersonBirth(@RequestBody PatchChangeBirth patchChangeBirth) {
        String retorno = "";
        if (patchChangeBirth.getBirth()==null|| patchChangeBirth.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonBirth(patchChangeBirth)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Charge
    /**
     * Metodo para modificar solo el cargo de la persona.  En primer lugar revisa que los campos no esten vacios y posteriormente
     *  realiza el llamado al metodo del servicio que permite ejecturar la funcionalidad
     * @param patchChangeCharge
     * @return cadena que representa el resultado de la operacion
     */
    @PatchMapping("/changeCharge")
    private String patchPersonCharge(@RequestBody PatchChangeCharge patchChangeCharge) {
        String retorno = "";
        if (patchChangeCharge.getCharge()==null|| patchChangeCharge.getId()==null){
            retorno="Hay campos obligatorios que no ha llenado";
        } else if(personService.updatePersonCharge(patchChangeCharge)!=1){
            retorno = "Tus datos fueron modificados";
        } else{
            retorno="No se pudo actualizar la informacion";
        }
        return retorno;
    }
    //Delete
    /**
     * Metodo para eliminar una persona de la aplicacion.
     * @param id
     * @return cadena que representa el resultado de la operacion
     */
    @DeleteMapping("/personDelete/{idPerson}")
    private String deletePerson(@PathVariable("idPerson") Integer id) {
        int auxiliar = personService.deletePerson(id);
        String retorno = "";
        if (auxiliar == 1) {
            retorno = "Se elimino exitosamente";
        } else {
            retorno = "No se elimino";
        }
        return retorno;
    }

}
