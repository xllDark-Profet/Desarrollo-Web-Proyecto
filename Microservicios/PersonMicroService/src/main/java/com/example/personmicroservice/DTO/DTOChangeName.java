package com.example.personmicroservice.DTO;

import org.jetbrains.annotations.NotNull;

public class DTOChangeName {
    @NotNull
    Integer id;
    @NotNull
    String name;

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
}
