package com.example.personmicroservice.DTO;

import org.jetbrains.annotations.NotNull;

public class DTOChangeSurname {
    @NotNull
    Integer id;
    @NotNull
    String surname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
