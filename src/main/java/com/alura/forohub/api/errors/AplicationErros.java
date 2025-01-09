package com.alura.forohub.api.errors;

public class AplicationErros extends RuntimeException{
    public  AplicationErros(String message) {
        super(message);
    }
}
