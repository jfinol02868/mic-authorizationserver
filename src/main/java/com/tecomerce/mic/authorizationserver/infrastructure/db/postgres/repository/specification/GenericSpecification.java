package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class GenericSpecification<T> implements Specification<T> {

    private final T filter;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        for (Field field : filter.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(filter);
                if (Objects.nonNull(value)) {
                    if (field.getType() == String.class) {
                        predicates.add(cb.like(root.get(field.getName()), "%" + value + "%"));
                    } else {
                        predicates.add(cb.equal(root.get(field.getName()), value));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
