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
