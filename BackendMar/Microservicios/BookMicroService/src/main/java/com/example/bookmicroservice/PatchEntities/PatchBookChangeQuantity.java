package com.example.bookmicroservice.PatchEntities;

import com.sun.istack.NotNull;

public class PatchBookChangeQuantity {
    @NotNull
    private Integer id;
    @NotNull
    private Integer quantity;

    //Get and set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
