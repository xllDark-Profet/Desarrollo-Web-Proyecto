package com.example.bookmicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int editorial_id;
    private String date_edition;
    private String image_url;
    private int quantify;


    public Book() {
    }


    public Book(String name, String description, int editorial_id, String date_edition, String image_url, int quantify) {
        this.name = name;
        this.description = description;
        this.editorial_id = editorial_id;
        this.date_edition = date_edition;
        this.image_url = image_url;
        this.quantify = quantify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getEditorial_id() {
        return editorial_id;
    }

    public void setEditorial_id(int editorial_id) {
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

    public int getQuantify() {
        return quantify;
    }

    public void setQuantify(int quantify) {
        this.quantify = quantify;
    }
}
