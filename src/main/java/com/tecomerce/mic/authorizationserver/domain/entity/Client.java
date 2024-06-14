package com.tecomerce.mic.authorizationserver.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private String id;
    private String clientId;
    private String clientSecret;
    private List<ClientAuthenticationMethod> authenticationMethods;
    private List<AuthorizationGrantType> authorizationGrantTypes;
    private List<RedirectUri> redirectUris;
    private List<Scope> scopes;

}
