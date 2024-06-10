package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T14:53:44+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClientDocMapperImpl implements ClientDocMapper {

    @Override
    public Client toEntity(ClientDocument document) {
        if ( document == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( document.getId() );
        client.clientId( document.getClientId() );
        client.clientSecret( document.getClientSecret() );
        List<String> list = document.getAuthenticationMethods();
        if ( list != null ) {
            client.authenticationMethods( new ArrayList<String>( list ) );
        }
        List<String> list1 = document.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            client.authorizationGrantTypes( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = document.getRedirectUris();
        if ( list2 != null ) {
            client.redirectUris( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = document.getScopes();
        if ( list3 != null ) {
            client.scopes( new ArrayList<String>( list3 ) );
        }
        client.requireProofKey( document.getRequireProofKey() );

        return client.build();
    }

    @Override
    public ClientDocument toDocument(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDocument.ClientDocumentBuilder clientDocument = ClientDocument.builder();

        clientDocument.id( entity.getId() );
        clientDocument.clientId( entity.getClientId() );
        clientDocument.clientSecret( entity.getClientSecret() );
        List<String> list = entity.getAuthenticationMethods();
        if ( list != null ) {
            clientDocument.authenticationMethods( new ArrayList<String>( list ) );
        }
        List<String> list1 = entity.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            clientDocument.authorizationGrantTypes( new ArrayList<String>( list1 ) );
        }
        List<String> list2 = entity.getRedirectUris();
        if ( list2 != null ) {
            clientDocument.redirectUris( new ArrayList<String>( list2 ) );
        }
        List<String> list3 = entity.getScopes();
        if ( list3 != null ) {
            clientDocument.scopes( new ArrayList<String>( list3 ) );
        }
        clientDocument.requireProofKey( entity.getRequireProofKey() );

        return clientDocument.build();
    }

    @Override
    public List<Client> toEntityList(List<ClientDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( documents.size() );
        for ( ClientDocument clientDocument : documents ) {
            list.add( toEntity( clientDocument ) );
        }

        return list;
    }

    @Override
    public List<ClientDocument> toDocumentList(List<Client> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientDocument> list = new ArrayList<ClientDocument>( entities.size() );
        for ( Client client : entities ) {
            list.add( toDocument( client ) );
        }

        return list;
    }
}
