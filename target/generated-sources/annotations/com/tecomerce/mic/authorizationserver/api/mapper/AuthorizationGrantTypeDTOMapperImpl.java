package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.AuthorizationGrantTypeDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
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
public class AuthorizationGrantTypeDTOMapperImpl implements AuthorizationGrantTypeDTOMapper {

    @Override
    public AuthorizationGrantType toEntity(AuthorizationGrantTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AuthorizationGrantType.AuthorizationGrantTypeBuilder authorizationGrantType = AuthorizationGrantType.builder();

        authorizationGrantType.id( dto.getId() );
        authorizationGrantType.name( dto.getName() );
        authorizationGrantType.description( dto.getDescription() );

        return authorizationGrantType.build();
    }

    @Override
    public AuthorizationGrantTypeDTO toDto(AuthorizationGrantType entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorizationGrantTypeDTO.AuthorizationGrantTypeDTOBuilder authorizationGrantTypeDTO = AuthorizationGrantTypeDTO.builder();

        authorizationGrantTypeDTO.id( entity.getId() );
        authorizationGrantTypeDTO.name( entity.getName() );
        authorizationGrantTypeDTO.description( entity.getDescription() );

        return authorizationGrantTypeDTO.build();
    }

    @Override
    public List<AuthorizationGrantType> toEntityList(List<AuthorizationGrantTypeDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<AuthorizationGrantType> list = new ArrayList<AuthorizationGrantType>( dtos.size() );
        for ( AuthorizationGrantTypeDTO authorizationGrantTypeDTO : dtos ) {
            list.add( toEntity( authorizationGrantTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<AuthorizationGrantTypeDTO> toDtoList(List<AuthorizationGrantType> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthorizationGrantTypeDTO> list = new ArrayList<AuthorizationGrantTypeDTO>( entities.size() );
        for ( AuthorizationGrantType authorizationGrantType : entities ) {
            list.add( toDto( authorizationGrantType ) );
        }

        return list;
    }
}
