package com.tecomerce.mic.authorizationserver.infrastructure.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

@Component
public class DynamicFilterMap {

    public Query queryFilter(Field[] fields, Object object, int page, int size, String direction, String... sortProperties) {

        Query query = new Query();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (Objects.nonNull(value)) query.addCriteria(Criteria.where(field.getName()).is(value));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        query.with(pageable);
        return query;
    }
}
