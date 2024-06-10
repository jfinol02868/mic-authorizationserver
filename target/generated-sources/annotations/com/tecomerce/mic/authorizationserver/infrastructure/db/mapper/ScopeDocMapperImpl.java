package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T13:57:00+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ScopeDocMapperImpl implements ScopeDocMapper {

    @Override
    public Scope toEntity(ScopeDocument dto) {
        if ( dto == null ) {
            return null;
        }

        Scope.ScopeBuilder scope = Scope.builder();

        scope.id( dto.getId() );
        scope.name( dto.getName() );
        scope.description( dto.getDescription() );

        return scope.build();
    }

    @Override
    public ScopeDocument toDocument(Scope entity) {
        if ( entity == null ) {
            return null;
        }

        ScopeDocument.ScopeDocumentBuilder scopeDocument = ScopeDocument.builder();

        scopeDocument.id( entity.getId() );
        scopeDocument.name( entity.getName() );
        scopeDocument.description( entity.getDescription() );

        return scopeDocument.build();
    }

    @Override
    public List<Scope> toEntityList(List<ScopeDocument> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Scope> list = new ArrayList<Scope>( dtos.size() );
        for ( ScopeDocument scopeDocument : dtos ) {
            list.add( toEntity( scopeDocument ) );
        }

        return list;
    }

    @Override
    public List<ScopeDocument> toDocumentList(List<Scope> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ScopeDocument> list = new ArrayList<ScopeDocument>( entities.size() );
        for ( Scope scope : entities ) {
            list.add( toDocument( scope ) );
        }

        return list;
    }
}
