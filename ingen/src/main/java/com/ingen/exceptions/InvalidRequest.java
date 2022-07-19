package com.ingen.exceptions;

public class InvalidRequest extends RuntimeException{

    public InvalidRequest (String message){
        super(message);
    }
    
}
