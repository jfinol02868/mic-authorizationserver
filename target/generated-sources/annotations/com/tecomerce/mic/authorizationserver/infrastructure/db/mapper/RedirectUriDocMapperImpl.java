package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T14:43:05+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class RedirectUriDocMapperImpl implements RedirectUriDocMapper {

    @Override
    public RedirectUri toEntity(RedirectUriDocument document) {
        if ( document == null ) {
            return null;
        }

        RedirectUri.RedirectUriBuilder redirectUri = RedirectUri.builder();

        redirectUri.id( document.getId() );
        redirectUri.uri( document.getUri() );
        redirectUri.description( document.getDescription() );

        return redirectUri.build();
    }

    @Override
    public RedirectUriDocument toDocument(RedirectUri entity) {
        if ( entity == null ) {
            return null;
        }

        RedirectUriDocument.RedirectUriDocumentBuilder redirectUriDocument = RedirectUriDocument.builder();

        redirectUriDocument.id( entity.getId() );
        redirectUriDocument.uri( entity.getUri() );
        redirectUriDocument.description( entity.getDescription() );

        return redirectUriDocument.build();
    }

    @Override
    public List<RedirectUri> toEntityList(List<RedirectUriDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<RedirectUri> list = new ArrayList<RedirectUri>( documents.size() );
        for ( RedirectUriDocument redirectUriDocument : documents ) {
            list.add( toEntity( redirectUriDocument ) );
        }

        return list;
    }

    @Override
    public List<RedirectUriDocument> toDocumentList(List<RedirectUri> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RedirectUriDocument> list = new ArrayList<RedirectUriDocument>( entities.size() );
        for ( RedirectUri redirectUri : entities ) {
            list.add( toDocument( redirectUri ) );
        }

        return list;
    }
}
