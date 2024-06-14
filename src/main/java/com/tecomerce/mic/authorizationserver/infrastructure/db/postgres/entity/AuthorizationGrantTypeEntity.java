package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("authorizationGrantType")
@Entity(name = "authorization_grant_types")
public class AuthorizationGrantTypeEntity {

        @Id
        private String id;
        private String value;
        private String description;
        @ManyToMany
        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        @JsonIgnore
        private List<ClientEntity> clients;
}
