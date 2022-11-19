package com.example.personmicroservice.PatchEntities;

import org.jetbrains.annotations.NotNull;
/**
 * Clase para realizar el patch de nombre
 */
public class PatchChangeName {
    @NotNull
    Integer id;
    @NotNull
    String name;

    /**
     * Metodo que permite obtener el id de una persona
     * @return id de una persona
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo que permite modificar el id de una persona
     * @param id
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodo que permite obtener el nombre de una persona
     * @return nombre persona
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que permite modificar el nombre de una persona
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
