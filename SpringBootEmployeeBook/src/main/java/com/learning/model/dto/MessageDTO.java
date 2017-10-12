package com.learning.model.dto;

/**
 * Created by mudassir on 17/01/2017.
 */
public class MessageDTO {

    private String message;
    private String type;

    public MessageDTO(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
