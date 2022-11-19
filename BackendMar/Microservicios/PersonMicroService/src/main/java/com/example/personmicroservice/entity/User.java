package com.example.personmicroservice.entity;

/**
 * Esta clase representa al objeto usuario el cual cuenta con un nombre de usuario y una coontrasena
 */
public class User {

    private String username;
    private String password;

    /**
     * Constructor sin parametros
     */
    public User() {
    }

    /**
     * Constructor con parametros
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Metodo que ayuda a obtener el nombre de usuario de una persona
     * @return nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo que ayuda a modificar el nombre de usuario de una persona
     * @param username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Metodo que ayuda a obtener la contrasena de una persona
     * @return contrasena de una persona
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo que permite modificar la contrasena de una persona
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
