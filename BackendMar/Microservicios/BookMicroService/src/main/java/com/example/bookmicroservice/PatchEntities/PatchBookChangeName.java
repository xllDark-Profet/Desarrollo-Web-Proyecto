package com.example.bookmicroservice.PatchEntities;

import org.jetbrains.annotations.NotNull;

public class PatchBookChangeName {
    @NotNull
    private Integer id;
    @NotNull
    private String name;

    //Get and set
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
