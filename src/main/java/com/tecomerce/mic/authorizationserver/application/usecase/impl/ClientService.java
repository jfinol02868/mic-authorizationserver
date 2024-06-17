package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.JpaClientRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService implements RegisteredClientRepository {

    private final JpaClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    @Override
    public void save(RegisteredClient registeredClient) { }

    public void delete(String id) {
        clientRepository.deleteById(id);
    }

    public void create(ClientDTO dto){
        if (Objects.isNull(dto.getId())) dto.setId(idGenerator.generateId(ClientEntity.class));
        dto.setClientSecret(passwordEncoder.encode(dto.getClientSecret()));
        ClientEntity client = clientFromDto(dto);
        clientRepository.save(client);
    }

    @Override
    public RegisteredClient findById(String id) {
        ClientEntity client = clientRepository.findByClientId(id).orElseThrow( () -> new RuntimeException("Client not found"));
        return ClientEntity.toRegisteredClient(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        ClientEntity client = clientRepository.findByClientId(clientId).orElseThrow( () -> new RuntimeException("Client not found"));
        return ClientEntity.toRegisteredClient(client);
    }

    private ClientEntity clientFromDto(ClientDTO dto){

        Set<ClientAuthenticationMethod> authenticationMethods = new HashSet<>();
        dto.getAuthenticationMethods().forEach(method -> {
            if(method.equals(ClientAuthenticationMethod.CLIENT_SECRET_BASIC.getValue())){
                authenticationMethods.add(ClientAuthenticationMethod.CLIENT_SECRET_BASIC);
            }
            if(method.equals(ClientAuthenticationMethod.CLIENT_SECRET_JWT.getValue())){
                authenticationMethods.add(ClientAuthenticationMethod.CLIENT_SECRET_JWT);
            }
            if(method.equals(ClientAuthenticationMethod.CLIENT_SECRET_POST.getValue())){
                authenticationMethods.add(ClientAuthenticationMethod.CLIENT_SECRET_POST);
            }
            if(method.equals(ClientAuthenticationMethod.NONE.getValue())){
                authenticationMethods.add(ClientAuthenticationMethod.NONE);
            }
            if(method.equals(ClientAuthenticationMethod.TLS_CLIENT_AUTH.getValue())){
                authenticationMethods.add(ClientAuthenticationMethod.TLS_CLIENT_AUTH);
            }
            if(method.equals(ClientAuthenticationMethod.SELF_SIGNED_TLS_CLIENT_AUTH.getValue())){
                authenticationMethods.add(ClientAuthenticationMethod.SELF_SIGNED_TLS_CLIENT_AUTH);
            }
            if(method.equals(ClientAuthenticationMethod.PRIVATE_KEY_JWT.getValue())){
                authenticationMethods.add(ClientAuthenticationMethod.PRIVATE_KEY_JWT);
            }
        });

        Set<AuthorizationGrantType> authorizationGrantTypes = new HashSet<>();
        dto.getAuthorizationGrantTypes().forEach(type -> {
            if(type.equals(AuthorizationGrantType.AUTHORIZATION_CODE.getValue())){
                authorizationGrantTypes.add(AuthorizationGrantType.AUTHORIZATION_CODE);
            }
            if(type.equals(AuthorizationGrantType.CLIENT_CREDENTIALS.getValue())){
                authorizationGrantTypes.add(AuthorizationGrantType.CLIENT_CREDENTIALS);
            }
            if(type.equals(AuthorizationGrantType.REFRESH_TOKEN.getValue())){
                authorizationGrantTypes.add(AuthorizationGrantType.REFRESH_TOKEN);
            }
            if(type.equals(AuthorizationGrantType.JWT_BEARER.getValue())){
                authorizationGrantTypes.add(AuthorizationGrantType.JWT_BEARER);
            }
            if(type.equals(AuthorizationGrantType.DEVICE_CODE.getValue())){
                authorizationGrantTypes.add(AuthorizationGrantType.DEVICE_CODE);
            }
            if(type.equals(AuthorizationGrantType.TOKEN_EXCHANGE.getValue())){
                authorizationGrantTypes.add(AuthorizationGrantType.TOKEN_EXCHANGE);
            }
        });

        authorizationGrantTypes.add(AuthorizationGrantType.AUTHORIZATION_CODE);

        return ClientEntity.builder()
                .id(dto.getId())
                .clientId(dto.getClientId())
                .clientSecret(passwordEncoder.encode(dto.getClientSecret()))
                .authenticationMethods(authenticationMethods)
                .authorizationGrantTypes(authorizationGrantTypes)
                .redirectUris(dto.getRedirectUris())
                .scopes(dto.getScopes())
                .requireProofKey(dto.isRequireProofKey())
                .build();
    }
}
