package com.example.personmicroservice.PatchEntities;

import org.jetbrains.annotations.NotNull;

/**
 * Clase para realizar el patch de fecha de nacimiento
 */
public class PatchChangeBirth {
    @NotNull
    Integer id;
    @NotNull
    String birth;

    /**
     * Metodo que permite obtener el id de una persona
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
     * Metodo que permite obtener la fecha de nacimiento de la persona
     * @return fecha nacimiento de la persona
     */
    public String getBirth() {
        return birth;
    }

    /**
     * Metodo que permite modificar la fecha de nacimiento de la persona
     * @param birth
     */

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
