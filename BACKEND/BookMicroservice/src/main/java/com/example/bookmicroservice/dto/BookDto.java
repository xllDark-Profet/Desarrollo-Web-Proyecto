package com.example.bookmicroservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private int editorial_id;

    @NotBlank
    private String date_edition;

    @NotBlank
    private String image_url;

    @NotBlank
    private int quantity;


    public BookDto(@NotBlank String name, @NotBlank String description, @NotBlank int editorial_id, @NotBlank String date_edition, @NotBlank String image_url, @NotBlank int quantity) {
        this.name = name;
        this.description = description;
        this.editorial_id = editorial_id;
        this.date_edition = date_edition;
        this.image_url = image_url;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
