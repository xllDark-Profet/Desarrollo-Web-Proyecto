package com.example.bookmicroservice.DTO;

import org.jetbrains.annotations.NotNull;

public class DTOBookChangeDescription {
    @NotNull
    private Integer id;
    private String description;

    //Get and set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
