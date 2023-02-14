package com.decrypto.challenge.exceptions;

public class ComitenteNotFoundException extends Exception {
    public ComitenteNotFoundException(Long id) {
        super("id " + id + " Not Found");
    }
}
