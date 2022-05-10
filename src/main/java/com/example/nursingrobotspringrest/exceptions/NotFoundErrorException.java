package com.example.nursingrobotspringrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundErrorException extends RuntimeException{
    public NotFoundErrorException(String message){
        super(message);
    }
}
