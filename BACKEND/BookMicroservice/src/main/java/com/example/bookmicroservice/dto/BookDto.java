package com.example.bookmicroservice.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @Min(0)
    private Integer cantidad;

    @Min(0)
    private Integer editorial_id;

    @NotBlank
    private String imagen_url;

    @NotBlank
    private String dia_edicion;

    public BookDto() {
    }

    public BookDto(@NotBlank String nombre, @NotBlank String descripcion, @Min(0) Integer cantidad, @Min(0) Integer editorial_id, @NotBlank String imagen_url, @NotBlank String dia_edicion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.editorial_id = editorial_id;
        this.imagen_url = imagen_url;
        this.dia_edicion = dia_edicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public Integer getEditorial_id() {
        return editorial_id;
    }

    public void setEditorial_id(Integer editorial_id) {
        this.editorial_id = editorial_id;
    }

    public String getDia_edicion() {
        return dia_edicion;
    }

    public void setDia_edicion(String dia_edicion) {
        this.dia_edicion = dia_edicion;
    }
}
