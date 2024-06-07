package com.tecomerce.mic.authorizationserver.api.controller;

import com.tecomerce.mic.authorizationserver.api.service.dto.MessageResponseDTO;
import com.tecomerce.mic.authorizationserver.domain.enums.MessageEnum;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.exception.ErrorMappingException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public MessageResponseDTO handlerEntityNotFoundException(EntityNotFoundException ex) {
        return MessageResponseDTO.builder()
                .code("E001")
                .message(String.format(MessageEnum.ENTITY_NOT_FOUND.getMessage(), ex.getMessage()))
                .details(new ArrayList<>())
                .timeStamp(ZonedDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ErrorMappingException.class)
    public MessageResponseDTO handlerErrorMappingException() {
        return MessageResponseDTO.builder()
                .code("M001")
                .message(MessageEnum.ERROR_MAPPING.getMessage())
                .details(new ArrayList<>())
                .timeStamp(ZonedDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessageResponseDTO handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return MessageResponseDTO.builder()
                .code("B001")
                .message(MessageEnum.METHOD_ARGUMENT_NOT_VALID.getMessage())
                .details(e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList())
                .timeStamp(ZonedDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public MessageResponseDTO handlerGenericError(Exception e) {
        return MessageResponseDTO.builder()
                .code("")
                .message("")
                .details(Collections.singletonList(e.getMessage()))
                .timeStamp(ZonedDateTime.now())
                .build();
    }
}
