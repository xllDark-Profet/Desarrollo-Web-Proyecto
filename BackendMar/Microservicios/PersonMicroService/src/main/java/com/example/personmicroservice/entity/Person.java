package com.example.personmicroservice.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Table
@Entity
/**
 * Esta clase representa el objeto del cliente o empleado de la libreria
 */
public class Person {

    @Id
    @Column
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String surname;

    @Column
    @NotNull
    private String birth;

    @Column
    @NotNull
    private String charge;

    @Column
    @org.jetbrains.annotations.NotNull
    private String username;

    @Column
    @NotNull
    private  String password;


    /**
     * Contructor de la clase
     */
    public Person() {
    }

    /**
     * Constructor de la clase con los parametros para inicializar el objeto Persona
     * @param id
     * @param name
     * @param surname
     * @param birth
     * @param charge
     * @param username
     * @param password
     */
    public Person(Integer id, String name, String surname, String birth, String charge, @org.jetbrains.annotations.NotNull String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.charge = charge;
        this.username = username;
        this.password = password;
    }

    /**
     * Metodo que ayuda a obtener el id de una persona
     * @return entero que representa el id de la persona
     */

    public Integer getId() {
        return id;
    }

    /**
     * Metodo que ayuda a modificar el id de una persona
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que ayuda a obtener el nombre de una persona
     * @return el nombre de la persona
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que ayuda a modificar el nombre de una persona
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que ayuda a obtener el apellido de una persona
     * @return apellido de la persona
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Metodo que ayuda a modificar el apellido de una persona
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Metodo que ayuda a obtener la fecha de nacimiento de una persona
     * @return fecha de nacimiento de la persona
     */
    public String getBirth() {
        return birth;
    }

    /**
     * Metodo que ayuda a modificar la fecha de  naciemiento de la persona
     * @param birth
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * Metodo que ayuda a obtener el rol de una persona
     * @return el rol en la libreria de la persona
     */
    public String getCharge() {
        return charge;
    }

    /**
     * Metodo que ayuda a modificar el rol de una persona
     * @param charge
     */
    public void setCharge(String charge) {
        this.charge = charge;
    }

    /**
     * Metodo que ayuda a obtener el nombre de usuario
     * @return nombre de usuario de la persona
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo que ayuda a modificar el nombre de usuario
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metodo que ayuda a obtener la contrasena de una persona
     * @return contrasena de una persona
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo que ayuda a modificar la contrasena de una persona
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
