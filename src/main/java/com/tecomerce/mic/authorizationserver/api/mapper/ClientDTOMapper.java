package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel= "spring")
public interface ClientDTOMapper {

    @Mapping(source = "authenticationMethods", target = "authenticationMethods", qualifiedByName = "stringToClientAuthenticationMethod")
    @Mapping(source = "authorizationGrantTypes", target = "authorizationGrantTypes", qualifiedByName = "stringToAuthorizationGrantTypes")
    @Mapping(source = "redirectUris", target = "redirectUris", qualifiedByName = "stringToRedirectUri")
    @Mapping(source = "scopes", target = "scopes", qualifiedByName = "stringToScope")
    Client toEntity(ClientDTO dto);

    @Named("stringToClientAuthenticationMethod")
    default List<ClientAuthenticationMethod> stringToClientAuthenticationMethod(List<String> authenticationMethods) {
        return authenticationMethods.stream()
                .map( c -> ClientAuthenticationMethod.builder()
                        .id(c)
                        .build())
                .collect(Collectors.toList());
    }

    @Named("stringToAuthorizationGrantTypes")
    default List<AuthorizationGrantType> stringToAuthorizationGrantTypes(List<String> authorizationGrantTypes) {
        return authorizationGrantTypes.stream()
                .map( a -> AuthorizationGrantType.builder()
                        .id(a)
                        .build())
                .collect(Collectors.toList());
    }

    @Named("stringToRedirectUri")
    default List<RedirectUri> stringToRedirectUri(List<String> redirectUri) {
        return redirectUri.stream()
                .map( r -> RedirectUri.builder()
                        .id(r)
                        .build())
                .collect(Collectors.toList());
    }

    @Named("stringToScope")
    default List<Scope> stringToScope(List<String> scopes) {
        return scopes.stream()
                .map( s -> Scope.builder()
                        .id(s)
                        .build())
                .collect(Collectors.toList());
    }

    @Mapping(source = "authenticationMethods", target = "authenticationMethods", qualifiedByName = "clientAuthenticationMethodToString")
    @Mapping(source = "authorizationGrantTypes", target = "authorizationGrantTypes", qualifiedByName = "authorizationGrantTypesToString")
    @Mapping(source = "redirectUris", target = "redirectUris", qualifiedByName = "redirectUriToString")
    @Mapping(source = "scopes", target = "scopes", qualifiedByName = "scopeToString")
    ClientDTO toDto(Client entity);

    @Named("clientAuthenticationMethodToString")
    default List<String> clientAuthenticationMethodToString(List<ClientAuthenticationMethod> authenticationMethods) {
        return authenticationMethods.stream()
                .map(ClientAuthenticationMethod::getId)
                .collect(Collectors.toList());
    }

    @Named("authorizationGrantTypesToString")
    default List<String> authorizationGrantTypesToString(List<AuthorizationGrantType> authorizationGrantTypes) {
        return authorizationGrantTypes.stream()
                .map( AuthorizationGrantType::getId)
                .collect(Collectors.toList());
    }

    @Named("redirectUriToString")
    default List<String> redirectUriToString(List<RedirectUri> redirectUri) {
        return redirectUri.stream()
                .map(RedirectUri::getId)
                .collect(Collectors.toList());
    }

    @Named("scopeToString")
    default List<String> scopeToString(List<Scope> scopes) {
        return scopes.stream()
                .map(Scope::getId)
                .collect(Collectors.toList());
    }

    default List<Client> toEntityList(List<ClientDTO> dtos){
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    default List<ClientDTO> toDtoList(List<Client> entities){
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
