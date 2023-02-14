package com.decrypto.challenge.exceptions;

public class MercadoNotFoundException extends Exception {
    public MercadoNotFoundException(Long id) {
        super("id " + id + " Not Found");
    }
}
