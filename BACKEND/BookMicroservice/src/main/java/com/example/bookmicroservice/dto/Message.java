package com.example.bookmicroservice.dto;

/**
 * Esta clase se encarga de representar la respuesta de una operacion con los metodos REST
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
