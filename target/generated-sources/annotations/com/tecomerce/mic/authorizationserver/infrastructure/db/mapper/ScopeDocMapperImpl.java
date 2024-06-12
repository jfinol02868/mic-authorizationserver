package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
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
public class ScopeDocMapperImpl implements ScopeDocMapper {

    @Override
    public Scope toModel(ScopeEntity dto) {
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
    public ScopeEntity toEntity(Scope entity) {
        if ( entity == null ) {
            return null;
        }

        ScopeEntity.ScopeEntityBuilder scopeEntity = ScopeEntity.builder();

        scopeEntity.id( entity.getId() );
        scopeEntity.name( entity.getName() );
        scopeEntity.description( entity.getDescription() );

        return scopeEntity.build();
    }

    @Override
    public List<Scope> toModelList(List<ScopeEntity> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Scope> list = new ArrayList<Scope>( dtos.size() );
        for ( ScopeEntity scopeEntity : dtos ) {
            list.add( toModel( scopeEntity ) );
        }

        return list;
    }

    @Override
    public List<ScopeEntity> toEntityList(List<Scope> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ScopeEntity> list = new ArrayList<ScopeEntity>( entities.size() );
        for ( Scope scope : entities ) {
            list.add( toEntity( scope ) );
        }

        return list;
    }
}
