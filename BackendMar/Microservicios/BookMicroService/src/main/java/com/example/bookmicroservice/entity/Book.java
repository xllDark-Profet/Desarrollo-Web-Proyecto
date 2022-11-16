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
    private String description;
    @Column
    @NotNull
    private Integer editorial_id;
    @Column
    @NotNull
    private String date_edition;
    @Column
    @NotNull
    private String image_url;
    @Column
    @NotNull
    private  Integer quantity;

    //Get and Set

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

    public Integer getEditorial_id() {
        return editorial_id;
    }

    public void setEditorial_id(Integer editorial_id) {
        this.editorial_id = editorial_id;
    }

    public String getDate_edition() {
        return date_edition;
    }

    public void setDate_edition(String date_edition) {
        this.date_edition = date_edition;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

