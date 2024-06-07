package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDetailDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T17:33:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClientDetailDocMapperImpl implements ClientDetailDocMapper {

    @Override
    public ClientDetail toEntity(ClientDetailDocument document) {
        if ( document == null ) {
            return null;
        }

        ClientDetail.ClientDetailBuilder clientDetail = ClientDetail.builder();

        clientDetail.id( document.getId() );
        clientDetail.clientId( document.getClientId() );
        clientDetail.clientSecret( document.getClientSecret() );
        List<ClientAuthenticationMethodDocument> list = document.getAuthenticationMethods();
        if ( list != null ) {
            clientDetail.authenticationMethods( new ArrayList<ClientAuthenticationMethodDocument>( list ) );
        }
        List<AuthorizationGrantTypeDocument> list1 = document.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            clientDetail.authorizationGrantTypes( new ArrayList<AuthorizationGrantTypeDocument>( list1 ) );
        }
        List<RedirectUriDocument> list2 = document.getRedirectUris();
        if ( list2 != null ) {
            clientDetail.redirectUris( new ArrayList<RedirectUriDocument>( list2 ) );
        }
        List<ScopeDocument> list3 = document.getScopes();
        if ( list3 != null ) {
            clientDetail.scopes( new ArrayList<ScopeDocument>( list3 ) );
        }
        clientDetail.requireProofKey( document.getRequireProofKey() );

        return clientDetail.build();
    }

    @Override
    public ClientDetailDocument toDocument(ClientDetail entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDetailDocument.ClientDetailDocumentBuilder clientDetailDocument = ClientDetailDocument.builder();

        clientDetailDocument.id( entity.getId() );
        clientDetailDocument.clientId( entity.getClientId() );
        clientDetailDocument.clientSecret( entity.getClientSecret() );
        List<ClientAuthenticationMethodDocument> list = entity.getAuthenticationMethods();
        if ( list != null ) {
            clientDetailDocument.authenticationMethods( new ArrayList<ClientAuthenticationMethodDocument>( list ) );
        }
        List<AuthorizationGrantTypeDocument> list1 = entity.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            clientDetailDocument.authorizationGrantTypes( new ArrayList<AuthorizationGrantTypeDocument>( list1 ) );
        }
        List<RedirectUriDocument> list2 = entity.getRedirectUris();
        if ( list2 != null ) {
            clientDetailDocument.redirectUris( new ArrayList<RedirectUriDocument>( list2 ) );
        }
        List<ScopeDocument> list3 = entity.getScopes();
        if ( list3 != null ) {
            clientDetailDocument.scopes( new ArrayList<ScopeDocument>( list3 ) );
        }
        clientDetailDocument.requireProofKey( entity.getRequireProofKey() );

        return clientDetailDocument.build();
    }

    @Override
    public List<ClientDetail> toEntityList(List<ClientDetailDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<ClientDetail> list = new ArrayList<ClientDetail>( documents.size() );
        for ( ClientDetailDocument clientDetailDocument : documents ) {
            list.add( toEntity( clientDetailDocument ) );
        }

        return list;
    }

    @Override
    public List<ClientDetailDocument> toDocumentList(List<ClientDetail> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientDetailDocument> list = new ArrayList<ClientDetailDocument>( entities.size() );
        for ( ClientDetail clientDetail : entities ) {
            list.add( toDocument( clientDetail ) );
        }

        return list;
    }
}
