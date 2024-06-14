package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("scope")
@Entity(name = "scopes")
public class ScopeEntity {

    @Id
    private String id;
    private String name;
    private String description;
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<ClientEntity> clients;
}
