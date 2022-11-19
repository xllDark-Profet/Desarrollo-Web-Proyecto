package com.example.personmicroservice.PatchEntities;

import org.jetbrains.annotations.NotNull;
/**
 * Clase para realizar el patch de rol
 */
public class PatchChangeCharge {

    @NotNull
    Integer id;
    @NotNull
    String charge;

    /**
     * Metodo que permite obtener el id de la persona
     * @return id de la persona
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo que permite modificar el id de la persona
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que permite obtener el rol de la persona
     * @return
     */
    public String getCharge() {
        return charge;
    }

    /**
     * Metodo que permite modificar el cargo de la persona
     * @param charge
     */
    public void setCharge(String charge) {
        this.charge = charge;
    }
}
