package com.example.usermicroservice.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Table
@Entity
public class User {
    @Id
    @Column
    @NotNull
    private String usar_name;
    @Column
    @NotNull
    private String password;

    @Column
    @org.jetbrains.annotations.NotNull
    private Integer person_id;

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getUsar_name() {
        return usar_name;
    }

    public void setUsar_name(String usar_name) {
        this.usar_name = usar_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
