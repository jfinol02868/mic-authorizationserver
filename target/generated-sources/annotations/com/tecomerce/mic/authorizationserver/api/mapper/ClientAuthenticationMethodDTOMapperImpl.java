package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientAuthenticationMethodDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
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
public class ClientAuthenticationMethodDTOMapperImpl implements ClientAuthenticationMethodDTOMapper {

    @Override
    public ClientAuthenticationMethod toEntity(ClientAuthenticationMethodDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClientAuthenticationMethod.ClientAuthenticationMethodBuilder clientAuthenticationMethod = ClientAuthenticationMethod.builder();

        clientAuthenticationMethod.id( dto.getId() );
        clientAuthenticationMethod.name( dto.getName() );
        clientAuthenticationMethod.description( dto.getDescription() );

        return clientAuthenticationMethod.build();
    }

    @Override
    public ClientAuthenticationMethodDTO toDto(ClientAuthenticationMethod entity) {
        if ( entity == null ) {
            return null;
        }

        ClientAuthenticationMethodDTO.ClientAuthenticationMethodDTOBuilder clientAuthenticationMethodDTO = ClientAuthenticationMethodDTO.builder();

        clientAuthenticationMethodDTO.id( entity.getId() );
        clientAuthenticationMethodDTO.name( entity.getName() );
        clientAuthenticationMethodDTO.description( entity.getDescription() );

        return clientAuthenticationMethodDTO.build();
    }

    @Override
    public List<ClientAuthenticationMethod> toEntityList(List<ClientAuthenticationMethodDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ClientAuthenticationMethod> list = new ArrayList<ClientAuthenticationMethod>( dtos.size() );
        for ( ClientAuthenticationMethodDTO clientAuthenticationMethodDTO : dtos ) {
            list.add( toEntity( clientAuthenticationMethodDTO ) );
        }

        return list;
    }

    @Override
    public List<ClientAuthenticationMethodDTO> toDtoList(List<ClientAuthenticationMethod> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientAuthenticationMethodDTO> list = new ArrayList<ClientAuthenticationMethodDTO>( entities.size() );
        for ( ClientAuthenticationMethod clientAuthenticationMethod : entities ) {
            list.add( toDto( clientAuthenticationMethod ) );
        }

        return list;
    }
}
