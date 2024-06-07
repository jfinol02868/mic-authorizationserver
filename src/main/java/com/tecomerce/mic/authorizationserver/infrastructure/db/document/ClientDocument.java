package com.tecomerce.mic.authorizationserver.infrastructure.db.document;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("client")
@Document(collection = "clients")
public class ClientDocument {

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
