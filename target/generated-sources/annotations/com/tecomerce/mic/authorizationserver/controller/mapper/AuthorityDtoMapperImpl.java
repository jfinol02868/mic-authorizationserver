package com.tecomerce.mic.authorizationserver.controller.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.AuthorityDTO;
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
public class AuthorityDtoMapperImpl implements AuthorityDtoMapper {

    @Override
    public AuthorityDTO toDto(Authority entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorityDTO.AuthorityDTOBuilder authorityDTO = AuthorityDTO.builder();

        authorityDTO.id( entity.getId() );
        authorityDTO.code( entity.getCode() );
        authorityDTO.name( entity.getName() );

        return authorityDTO.build();
    }

    @Override
    public Authority toEntity(AuthorityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Authority.AuthorityBuilder authority = Authority.builder();

        authority.id( dto.getId() );
        authority.code( dto.getCode() );
        authority.name( dto.getName() );

        return authority.build();
    }

    @Override
    public List<AuthorityDTO> toDtoList(List<Authority> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthorityDTO> list = new ArrayList<AuthorityDTO>( entities.size() );
        for ( Authority authority : entities ) {
            list.add( toDto( authority ) );
        }

        return list;
    }

    @Override
    public List<Authority> toEntityList(List<AuthorityDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Authority> list = new ArrayList<Authority>( dtos.size() );
        for ( AuthorityDTO authorityDTO : dtos ) {
            list.add( toEntity( authorityDTO ) );
        }

        return list;
    }
}
