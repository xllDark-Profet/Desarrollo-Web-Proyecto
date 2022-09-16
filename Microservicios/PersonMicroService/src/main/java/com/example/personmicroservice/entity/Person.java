package com.example.personmicroservice.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Table
@Entity

public class Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private String apellido;

    @Column
    @NotNull
    private String fechaNacimiento;

    @Column
    @NotNull
    private String cargo;


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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}
