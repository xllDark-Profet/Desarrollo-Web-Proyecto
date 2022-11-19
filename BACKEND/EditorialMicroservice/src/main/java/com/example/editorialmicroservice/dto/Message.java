package com.example.editorialmicroservice.dto;

/**
 * Esta clase representa al objeto mensaje que indicara los resultados de la operacion con los metodos rest
 */
public class Message {

    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
