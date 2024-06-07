package com.tecomerce.mic.authorizationserver.infrastructure.db.document;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
public class ClientDetailDocument {

    @Id
    private String id;
    @Indexed(unique = true)
    private String clientId;
    private String clientSecret;
    @DocumentReference(collection = "clientAuthenticationMethod", lazy = true)
    private List<ClientAuthenticationMethodDocument> authenticationMethods;
    @DocumentReference(collection = "authorizationGrantTypes", lazy = true)
    private List<AuthorizationGrantTypeDocument> authorizationGrantTypes;
    @DocumentReference(collection = "redirectUris", lazy = true)
    private List<RedirectUriDocument> redirectUris;
    @DocumentReference(collection = "scopes", lazy = true)
    private List<ScopeDocument> scopes;
    private Boolean requireProofKey;

}
