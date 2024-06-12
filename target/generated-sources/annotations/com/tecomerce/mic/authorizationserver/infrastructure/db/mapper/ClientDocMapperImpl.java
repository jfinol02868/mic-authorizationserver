package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-12T13:15:44+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClientDocMapperImpl implements ClientDocMapper {

    @Override
    public Client toModel(ClientEntity client) {
        if ( client == null ) {
            return null;
        }

        Client.ClientBuilder client1 = Client.builder();

        client1.id( client.getId() );
        client1.clientId( client.getClientId() );
        client1.clientSecret( client.getClientSecret() );
        List<String> list = client.getAuthenticationMethods();
        if ( list != null ) {
            client1.authenticationMethods( new ArrayList<String>( list ) );
        }
        List<String> list1 = client.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            client1.authorizationGrantTypes( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = client.getRedirectUris();
        if ( list2 != null ) {
            client1.redirectUris( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = client.getScopes();
        if ( list3 != null ) {
            client1.scopes( new ArrayList<String>( list3 ) );
        }
        client1.requireProofKey( client.getRequireProofKey() );

        return client1.build();
    }

    @Override
    public ClientEntity toEntity(Client model) {
        if ( model == null ) {
            return null;
        }

        ClientEntity.ClientEntityBuilder clientEntity = ClientEntity.builder();

        clientEntity.id( model.getId() );
        clientEntity.clientId( model.getClientId() );
        clientEntity.clientSecret( model.getClientSecret() );
        List<String> list = model.getAuthenticationMethods();
        if ( list != null ) {
            clientEntity.authenticationMethods( new ArrayList<String>( list ) );
        }
        List<String> list1 = model.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            clientEntity.authorizationGrantTypes( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = model.getRedirectUris();
        if ( list2 != null ) {
            clientEntity.redirectUris( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = model.getScopes();
        if ( list3 != null ) {
            clientEntity.scopes( new ArrayList<String>( list3 ) );
        }
        clientEntity.requireProofKey( model.getRequireProofKey() );

        return clientEntity.build();
    }

    @Override
    public List<Client> toModelList(List<ClientEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( entities.size() );
        for ( ClientEntity clientEntity : entities ) {
            list.add( toModel( clientEntity ) );
        }

        return list;
    }

    @Override
    public List<ClientEntity> toEntityList(List<Client> models) {
        if ( models == null ) {
            return null;
        }

        List<ClientEntity> list = new ArrayList<ClientEntity>( models.size() );
        for ( Client client : models ) {
            list.add( toEntity( client ) );
        }

        return list;
    }
}
