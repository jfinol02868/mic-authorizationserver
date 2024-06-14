package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService implements RegisteredClientRepository  {

    private final ClientRepository clientRepository;

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return this.toRegisteredClient(clientRepository.findByClientId(id));
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return this.toRegisteredClient(clientRepository.findByClientId(clientId));
    }

    private RegisteredClient toRegisteredClient(Client client) {

        Set<String> clientAuthenticationMethods = StringUtils.commaDelimitedListToSet(client.getAuthenticationMethods().stream()
                .map(ClientAuthenticationMethod::getValue).collect(Collectors.joining(",")));

        Set<String> authorizationGrantTypes = StringUtils.commaDelimitedListToSet(client.getAuthorizationGrantTypes().stream()
                .map(com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType::getValue).collect(Collectors.joining(",")));

        Set<String> redirectUris = StringUtils.commaDelimitedListToSet(client.getRedirectUris().stream()
                .map(RedirectUri::getUri).collect(Collectors.joining(",")));

        Set<String> clientScopes = StringUtils.commaDelimitedListToSet(client.getScopes().stream()
                .map(Scope::getName).collect(Collectors.joining(",")));

        RegisteredClient.Builder builder = RegisteredClient.withId(client.getId())
                .clientId(client.getClientId())
                .clientSecret(client.getClientSecret())
                .clientAuthenticationMethods(methods -> clientAuthenticationMethods.forEach(method -> methods.add(resolveClientAuthenticationMethod(method))))
                .authorizationGrantTypes((grantTypes) -> authorizationGrantTypes.forEach(grantType -> grantTypes.add(resolveAuthorizationGrantType(grantType))))
                .redirectUris((uris) -> uris.addAll(redirectUris))
                .scopes((scopes) -> scopes.addAll(clientScopes));
        return builder.build();
    }

    private static AuthorizationGrantType resolveAuthorizationGrantType(String authorizationGrantType) {
        if (AuthorizationGrantType.AUTHORIZATION_CODE.getValue().equals(authorizationGrantType)) {
            return AuthorizationGrantType.AUTHORIZATION_CODE;
        } else if (AuthorizationGrantType.CLIENT_CREDENTIALS.getValue().equals(authorizationGrantType)) {
            return AuthorizationGrantType.CLIENT_CREDENTIALS;
        } else if (AuthorizationGrantType.REFRESH_TOKEN.getValue().equals(authorizationGrantType)) {
            return AuthorizationGrantType.REFRESH_TOKEN;
        }
        return new AuthorizationGrantType(authorizationGrantType);
    }

    private static org.springframework.security.oauth2.core.ClientAuthenticationMethod resolveClientAuthenticationMethod(String clientAuthenticationMethod) {
        if (org.springframework.security.oauth2.core.ClientAuthenticationMethod.CLIENT_SECRET_BASIC.getValue().equals(clientAuthenticationMethod)) {
            return org.springframework.security.oauth2.core.ClientAuthenticationMethod.CLIENT_SECRET_BASIC;
        } else if (org.springframework.security.oauth2.core.ClientAuthenticationMethod.CLIENT_SECRET_POST.getValue().equals(clientAuthenticationMethod)) {
            return org.springframework.security.oauth2.core.ClientAuthenticationMethod.CLIENT_SECRET_POST;
        } else if (org.springframework.security.oauth2.core.ClientAuthenticationMethod.NONE.getValue().equals(clientAuthenticationMethod)) {
            return org.springframework.security.oauth2.core.ClientAuthenticationMethod.NONE;
        }
        return new org.springframework.security.oauth2.core.ClientAuthenticationMethod(clientAuthenticationMethod);
    }

}
