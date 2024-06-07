package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T14:43:04+0200",
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

        client.id( dto.getId() );
        client.clientId( dto.getClientId() );
        client.clientSecret( dto.getClientSecret() );
        List<String> list = dto.getAuthenticationMethods();
        if ( list != null ) {
            client.authenticationMethods( new ArrayList<String>( list ) );
        }
        List<String> list1 = dto.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            client.authorizationGrantTypes( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = dto.getRedirectUris();
        if ( list2 != null ) {
            client.redirectUris( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = dto.getScopes();
        if ( list3 != null ) {
            client.scopes( new ArrayList<String>( list3 ) );
        }
        client.requireProofKey( dto.getRequireProofKey() );

        return client.build();
    }

    @Override
    public ClientDTO toDto(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDTO.ClientDTOBuilder clientDTO = ClientDTO.builder();

        clientDTO.id( entity.getId() );
        clientDTO.clientId( entity.getClientId() );
        clientDTO.clientSecret( entity.getClientSecret() );
        List<String> list = entity.getAuthenticationMethods();
        if ( list != null ) {
            clientDTO.authenticationMethods( new ArrayList<String>( list ) );
        }
        List<String> list1 = entity.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            clientDTO.authorizationGrantTypes( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = entity.getRedirectUris();
        if ( list2 != null ) {
            clientDTO.redirectUris( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = entity.getScopes();
        if ( list3 != null ) {
            clientDTO.scopes( new ArrayList<String>( list3 ) );
        }
        clientDTO.requireProofKey( entity.getRequireProofKey() );

        return clientDTO.build();
    }

    @Override
    public List<Client> toEntityList(List<ClientDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtos.size() );
        for ( ClientDTO clientDTO : dtos ) {
            list.add( toEntity( clientDTO ) );
        }

        return list;
    }

    @Override
    public List<ClientDTO> toDtoList(List<Client> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( entities.size() );
        for ( Client client : entities ) {
            list.add( toDto( client ) );
        }

        return list;
    }
}
