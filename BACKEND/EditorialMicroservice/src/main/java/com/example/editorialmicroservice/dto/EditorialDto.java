package com.example.editorialmicroservice.dto;

import javax.validation.constraints.NotBlank;

/**
 * Esta clase repressenta al objeto editorial para aplicar el patron DTO
 */
public class EditorialDto {
    @NotBlank
    private String nombre;

    @NotBlank
    private String web_url;

    public EditorialDto(@NotBlank String nombre, @NotBlank String web_url) {
        this.nombre = nombre;
        this.web_url = web_url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }
}
