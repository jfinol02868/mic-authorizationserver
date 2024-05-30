package com.tecomerce.mic.authorizationserver.repository.mapper;

import com.tecomerce.mic.authorizationserver.repository.document.AuthorityDocument;
import com.tecomerce.mic.authorizationserver.service.entity.Authority;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T17:14:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public AuthorityDocument toDocument(Authority entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorityDocument.AuthorityDocumentBuilder authorityDocument = AuthorityDocument.builder();

        authorityDocument.id( entity.getId() );
        authorityDocument.code( entity.getCode() );
        authorityDocument.name( entity.getName() );

        return authorityDocument.build();
    }

    @Override
    public Authority toEntity(AuthorityDocument document) {
        if ( document == null ) {
            return null;
        }

        Authority.AuthorityBuilder authority = Authority.builder();

        authority.id( document.getId() );
        authority.code( document.getCode() );
        authority.name( document.getName() );

        return authority.build();
    }

    @Override
    public List<AuthorityDocument> toDocumentList(List<Authority> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthorityDocument> list = new ArrayList<AuthorityDocument>( entities.size() );
        for ( Authority authority : entities ) {
            list.add( toDocument( authority ) );
        }

        return list;
    }

    @Override
    public List<Authority> toEntityList(List<AuthorityDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<Authority> list = new ArrayList<Authority>( documents.size() );
        for ( AuthorityDocument authorityDocument : documents ) {
            list.add( toEntity( authorityDocument ) );
        }

        return list;
    }
}
