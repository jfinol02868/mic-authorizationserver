package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T19:16:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class AuthorizationGrantTypeDocMapperImpl implements AuthorizationGrantTypeDocMapper {

    @Override
    public AuthorizationGrantType toEntity(AuthorizationGrantTypeDocument document) {
        if ( document == null ) {
            return null;
        }

        AuthorizationGrantType.AuthorizationGrantTypeBuilder authorizationGrantType = AuthorizationGrantType.builder();

        authorizationGrantType.id( document.getId() );
        authorizationGrantType.name( document.getName() );
        authorizationGrantType.description( document.getDescription() );

        return authorizationGrantType.build();
    }

    @Override
    public AuthorizationGrantTypeDocument toDocument(AuthorizationGrantType entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorizationGrantTypeDocument.AuthorizationGrantTypeDocumentBuilder authorizationGrantTypeDocument = AuthorizationGrantTypeDocument.builder();

        authorizationGrantTypeDocument.id( entity.getId() );
        authorizationGrantTypeDocument.name( entity.getName() );
        authorizationGrantTypeDocument.description( entity.getDescription() );

        return authorizationGrantTypeDocument.build();
    }

    @Override
    public List<AuthorizationGrantType> toEntityList(List<AuthorizationGrantTypeDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<AuthorizationGrantType> list = new ArrayList<AuthorizationGrantType>( documents.size() );
        for ( AuthorizationGrantTypeDocument authorizationGrantTypeDocument : documents ) {
            list.add( toEntity( authorizationGrantTypeDocument ) );
        }

        return list;
    }

    @Override
    public List<AuthorizationGrantTypeDocument> toDocumentList(List<AuthorizationGrantType> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthorizationGrantTypeDocument> list = new ArrayList<AuthorizationGrantTypeDocument>( entities.size() );
        for ( AuthorizationGrantType authorizationGrantType : entities ) {
            list.add( toDocument( authorizationGrantType ) );
        }

        return list;
    }
}
