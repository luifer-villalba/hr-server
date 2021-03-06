package com.swnat.dto;

import java.io.Serializable;

/**
 * @author luifer
 * @version 1.0
 * @since 23-08-2020
 */
public class MessageDTO implements Serializable{

    
    private static final long serialVersionUID = 5881806636583130071L;
    
    private String message;

    public MessageDTO(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}