package com.tecomerce.mic.authorizationserver.controller.service.dto;

import lombok.Getter;

@Getter
public enum SortEnumDTO {

    ASC("ASC"),
    DESC("DESC");

    private final String value;

    SortEnumDTO(String value) {
        this.value = value;
    }

}
