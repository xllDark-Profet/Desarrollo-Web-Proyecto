package com.example.personmicroservice.PatchEntities;

import org.jetbrains.annotations.NotNull;

public class PatchChangeBirth {
    @NotNull
    Integer id;
    @NotNull
    String birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
