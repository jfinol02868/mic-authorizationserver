package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RedirectUriDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
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
public class RedirectUriDTOMapperImpl implements RedirectUriDTOMapper {

    @Override
    public RedirectUri toEntity(RedirectUriDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RedirectUri.RedirectUriBuilder redirectUri = RedirectUri.builder();

        redirectUri.id( dto.getId() );
        redirectUri.uri( dto.getUri() );
        redirectUri.description( dto.getDescription() );

        return redirectUri.build();
    }

    @Override
    public RedirectUriDTO toDto(RedirectUri entity) {
        if ( entity == null ) {
            return null;
        }

        RedirectUriDTO.RedirectUriDTOBuilder redirectUriDTO = RedirectUriDTO.builder();

        redirectUriDTO.id( entity.getId() );
        redirectUriDTO.uri( entity.getUri() );
        redirectUriDTO.description( entity.getDescription() );

        return redirectUriDTO.build();
    }

    @Override
    public List<RedirectUri> toEntityList(List<RedirectUriDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<RedirectUri> list = new ArrayList<RedirectUri>( dtos.size() );
        for ( RedirectUriDTO redirectUriDTO : dtos ) {
            list.add( toEntity( redirectUriDTO ) );
        }

        return list;
    }

    @Override
    public List<RedirectUriDTO> toDtoList(List<RedirectUri> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RedirectUriDTO> list = new ArrayList<RedirectUriDTO>( entities.size() );
        for ( RedirectUri redirectUri : entities ) {
            list.add( toDto( redirectUri ) );
        }

        return list;
    }
}
