package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ScopeDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
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
public class ScopeDTOMapperImpl implements ScopeDTOMapper {

    @Override
    public Scope toEntity(ScopeDTO dto) {
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
    public ScopeDTO toDto(Scope entity) {
        if ( entity == null ) {
            return null;
        }

        ScopeDTO.ScopeDTOBuilder scopeDTO = ScopeDTO.builder();

        scopeDTO.id( entity.getId() );
        scopeDTO.name( entity.getName() );
        scopeDTO.description( entity.getDescription() );

        return scopeDTO.build();
    }

    @Override
    public List<Scope> toEntityList(List<ScopeDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Scope> list = new ArrayList<Scope>( dtos.size() );
        for ( ScopeDTO scopeDTO : dtos ) {
            list.add( toEntity( scopeDTO ) );
        }

        return list;
    }

    @Override
    public List<ScopeDTO> toDtoList(List<Scope> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ScopeDTO> list = new ArrayList<ScopeDTO>( entities.size() );
        for ( Scope scope : entities ) {
            list.add( toDto( scope ) );
        }

        return list;
    }
}
