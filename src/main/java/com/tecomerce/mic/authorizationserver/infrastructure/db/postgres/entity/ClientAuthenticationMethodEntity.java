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
@TypeAlias("AuthenticationMethod")
@Entity(name = "authentication_methods")
public class ClientAuthenticationMethodEntity {

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
