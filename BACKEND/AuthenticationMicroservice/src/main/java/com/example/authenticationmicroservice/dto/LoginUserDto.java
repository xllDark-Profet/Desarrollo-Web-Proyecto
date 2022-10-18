package com.example.authenticationmicroservice.dto;


import javax.validation.constraints.NotBlank;

public class LoginUserDto {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
