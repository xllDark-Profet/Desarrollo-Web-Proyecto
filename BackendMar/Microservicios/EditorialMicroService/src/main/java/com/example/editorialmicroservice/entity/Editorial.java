package com.example.editorialmicroservice.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Table
@Entity
public class Editorial {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    private String web_site;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name= nombre;
    }

    public String getUrl() {
        return web_site;
    }

    public void setUrl(String url) {
        this.web_site = url;
    }


}
