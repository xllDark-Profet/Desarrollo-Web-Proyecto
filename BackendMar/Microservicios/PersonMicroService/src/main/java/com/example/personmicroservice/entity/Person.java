package com.example.personmicroservice.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Table
@Entity

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
     * Nombre:
     * Descripcion:
     * Entrada:
     * Salida:
     */

    public Person() {
    }

    public Person(Integer id, String name, String surname, String birth, String charge, @org.jetbrains.annotations.NotNull String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.charge = charge;
        this.username = username;
        this.password = password;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
