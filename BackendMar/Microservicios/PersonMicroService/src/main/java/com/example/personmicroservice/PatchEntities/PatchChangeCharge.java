package com.example.personmicroservice.PatchEntities;

import org.jetbrains.annotations.NotNull;

public class PatchChangeCharge {

    @NotNull
    Integer id;
    @NotNull
    String charge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
