package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

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
}
