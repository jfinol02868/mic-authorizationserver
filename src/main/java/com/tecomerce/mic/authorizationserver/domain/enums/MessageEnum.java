package com.tecomerce.mic.authorizationserver.domain.enums;

import lombok.Getter;

@Getter
public enum MessageEnum {

    ENTITY_NOT_FOUND("Entity with id %s not found"),
    METHOD_ARGUMENT_NOT_VALID("Argument not valid"),
    ERROR_MAPPING("Error mapping filter properties"),
    GENERIC_ERROR("Generic error");

    private final String message;

    MessageEnum(String message) {
        this.message = message;
    }
}
