package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("role")
@Entity(name = "roles")
public class RoleEntity implements Serializable {

    @Id
    private String id;
    private String roleName;
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<UserEntity> users;
}
