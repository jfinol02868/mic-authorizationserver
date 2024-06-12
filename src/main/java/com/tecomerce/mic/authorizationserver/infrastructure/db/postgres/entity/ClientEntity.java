package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("client")
@Entity(name = "clients")
public class ClientEntity {

    @Id
    private String id;
    private String clientId;
    private String clientSecret;
    private List<String> authenticationMethods;
    private List<String> authorizationGrantTypes;
    private List<String> redirectUris;
    private List<String> scopes;
    private Boolean requireProofKey;

}
