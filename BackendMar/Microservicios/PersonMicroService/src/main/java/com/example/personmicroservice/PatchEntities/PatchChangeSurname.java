package com.example.personmicroservice.PatchEntities;

import org.jetbrains.annotations.NotNull;
/**
 * Clase para realizar el patch de apellido
 */
public class PatchChangeSurname {
    @NotNull
    Integer id;
    @NotNull
    String surname;

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
     * Metodo que permite obtener el apellido de una persona
     * @return apellido persona
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Metodo que permite modificar el apellido de una persona
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
