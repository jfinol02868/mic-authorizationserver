package com.tecomerce.mic.authorizationserver.domain.entity;


import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetail {

    private String id;
    private String clientId;
    private String clientSecret;
    private List<ClientAuthenticationMethodDocument> authenticationMethods;
    private List<AuthorizationGrantTypeDocument> authorizationGrantTypes;
    private List<RedirectUriDocument> redirectUris;
    private List<ScopeDocument> scopes;
    private Boolean requireProofKey;

}
