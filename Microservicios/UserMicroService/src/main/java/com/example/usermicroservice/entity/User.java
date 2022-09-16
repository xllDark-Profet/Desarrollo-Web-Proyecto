package com.example.usermicroservice.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Table
@Entity
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
