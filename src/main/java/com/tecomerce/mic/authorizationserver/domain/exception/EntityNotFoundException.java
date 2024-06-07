package com.tecomerce.mic.authorizationserver.domain.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
