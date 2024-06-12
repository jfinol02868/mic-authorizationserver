package com.tecomerce.mic.authorizationserver.domain.entity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationGrantType implements Specification<AuthorizationGrantType> {

        private String id;
        private String value;
        private String description;

        @Override
        public Predicate toPredicate(Root<AuthorizationGrantType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                if(Objects.nonNull(id)) predicate.add(cb.equal(root.get("id"), this.id));
                if(Objects.nonNull(value)) predicate.add(cb.equal(root.get("value"), this.value));
                if(Objects.nonNull(description)) predicate.add(cb.equal(root.get("description"), this.description));
                return cb.and(predicate.toArray(new Predicate[predicate.size()]));
        }
}
