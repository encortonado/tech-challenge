package br.com.fiap.tech.challenge.infrastucture.exceptions;

import org.springframework.http.HttpStatus;

public class CustomErrorTypeException extends RuntimeException{

    public CustomErrorTypeException (String msg) {
        super(msg);
    }
}
