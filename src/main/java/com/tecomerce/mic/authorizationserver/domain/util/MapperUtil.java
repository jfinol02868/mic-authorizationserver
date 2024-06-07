package com.tecomerce.mic.authorizationserver.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecomerce.mic.authorizationserver.domain.exception.ErrorMappingException;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    public <T> Object mappingEntity(String filterProperties, Class<?> clazz) {
        ObjectMapper mapping = new ObjectMapper();
        try {
            return mapping.readValue(filterProperties, clazz);
        } catch (JsonProcessingException e) {
            throw new ErrorMappingException();
        }
    }
}
