package com.tecomerce.mic.authorizationserver.domain.entity;


import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.AuthorizationGrantTypeEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RedirectUriEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetail {

    private String id;
    private String clientId;
    private String clientSecret;
    private List<ClientAuthenticationMethodEntity> authenticationMethods;
    private List<AuthorizationGrantTypeEntity> authorizationGrantTypes;
    private List<RedirectUriEntity> redirectUris;
    private List<ScopeEntity> scopes;
    private Boolean requireProofKey;

}
