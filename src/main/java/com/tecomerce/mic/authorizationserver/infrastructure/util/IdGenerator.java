package com.tecomerce.mic.authorizationserver.infrastructure.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

import static java.lang.String.join;

@Component
public class IdGenerator {

    @Value("${app.micro}")
    private String micro;
    @Value("${app.environment}")
    private String environment;
    private static final String DELIMITER = "::";

    public String generateId(final Class<?> clazz) {
        return join(DELIMITER, micro, getAlias(clazz), getUUID(), environment).toUpperCase();
    }

    protected String getAlias(final Class<?> clazz) {
        final TypeAlias annotation = clazz.getAnnotation(TypeAlias.class);
        if (Objects.nonNull(annotation)) {
            return annotation.value();
        } else {
            throw new IllegalStateException("No alias found for the class '" + clazz.getName() + "'");
        }
    }

    protected String getUUID() {
        return UUID.randomUUID().toString();
    }
}
