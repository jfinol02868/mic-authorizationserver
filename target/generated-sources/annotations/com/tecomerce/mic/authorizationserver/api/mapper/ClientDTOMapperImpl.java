package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T10:40:19+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClientDTOMapperImpl implements ClientDTOMapper {

    @Override
    public Client toEntity(ClientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.authenticationMethods( stringToClientAuthenticationMethod( dto.getAuthenticationMethods() ) );
        client.authorizationGrantTypes( stringToAuthorizationGrantTypes( dto.getAuthorizationGrantTypes() ) );
        client.redirectUris( stringToRedirectUri( dto.getRedirectUris() ) );
        client.scopes( stringToScope( dto.getScopes() ) );
        client.id( dto.getId() );
        client.clientId( dto.getClientId() );
        client.clientSecret( dto.getClientSecret() );

        return client.build();
    }

    @Override
    public ClientDTO toDto(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDTO.ClientDTOBuilder clientDTO = ClientDTO.builder();

        clientDTO.authenticationMethods( clientAuthenticationMethodToString( entity.getAuthenticationMethods() ) );
        clientDTO.authorizationGrantTypes( authorizationGrantTypesToString( entity.getAuthorizationGrantTypes() ) );
        clientDTO.redirectUris( redirectUriToString( entity.getRedirectUris() ) );
        clientDTO.scopes( scopeToString( entity.getScopes() ) );
        clientDTO.id( entity.getId() );
        clientDTO.clientId( entity.getClientId() );
        clientDTO.clientSecret( entity.getClientSecret() );

        return clientDTO.build();
    }
}
