package com.example.bookmicroservice.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Table
@Entity

public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String description;



    @Column
    @NotNull
    private String editorial;

    @Column
    @NotNull
    private String fechaEdicion;

    @Column
    @NotNull
    private String imageUrl;



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(String fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

