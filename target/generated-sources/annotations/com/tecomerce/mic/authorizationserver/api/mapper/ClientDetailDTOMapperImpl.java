package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDetailDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
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
public class ClientDetailDTOMapperImpl implements ClientDetailDTOMapper {

    @Override
    public ClientDetail toEntity(ClientDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClientDetail.ClientDetailBuilder clientDetail = ClientDetail.builder();

        clientDetail.id( dto.getId() );
        clientDetail.clientId( dto.getClientId() );
        clientDetail.clientSecret( dto.getClientSecret() );
        List<ClientAuthenticationMethodDocument> list = dto.getAuthenticationMethods();
        if ( list != null ) {
            clientDetail.authenticationMethods( new ArrayList<ClientAuthenticationMethodDocument>( list ) );
        }
        List<AuthorizationGrantTypeDocument> list1 = dto.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            clientDetail.authorizationGrantTypes( new ArrayList<AuthorizationGrantTypeDocument>( list1 ) );
        }
        List<RedirectUriDocument> list2 = dto.getRedirectUris();
        if ( list2 != null ) {
            clientDetail.redirectUris( new ArrayList<RedirectUriDocument>( list2 ) );
        }
        List<ScopeDocument> list3 = dto.getScopes();
        if ( list3 != null ) {
            clientDetail.scopes( new ArrayList<ScopeDocument>( list3 ) );
        }
        clientDetail.requireProofKey( dto.getRequireProofKey() );

        return clientDetail.build();
    }

    @Override
    public ClientDetailDTO toDto(ClientDetail entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDetailDTO.ClientDetailDTOBuilder clientDetailDTO = ClientDetailDTO.builder();

        clientDetailDTO.id( entity.getId() );
        clientDetailDTO.clientId( entity.getClientId() );
        clientDetailDTO.clientSecret( entity.getClientSecret() );
        List<ClientAuthenticationMethodDocument> list = entity.getAuthenticationMethods();
        if ( list != null ) {
            clientDetailDTO.authenticationMethods( new ArrayList<ClientAuthenticationMethodDocument>( list ) );
        }
        List<AuthorizationGrantTypeDocument> list1 = entity.getAuthorizationGrantTypes();
        if ( list1 != null ) {
            clientDetailDTO.authorizationGrantTypes( new ArrayList<AuthorizationGrantTypeDocument>( list1 ) );
        }
        List<RedirectUriDocument> list2 = entity.getRedirectUris();
        if ( list2 != null ) {
            clientDetailDTO.redirectUris( new ArrayList<RedirectUriDocument>( list2 ) );
        }
        List<ScopeDocument> list3 = entity.getScopes();
        if ( list3 != null ) {
            clientDetailDTO.scopes( new ArrayList<ScopeDocument>( list3 ) );
        }
        clientDetailDTO.requireProofKey( entity.getRequireProofKey() );

        return clientDetailDTO.build();
    }

    @Override
    public List<ClientDetail> toEntityList(List<ClientDetailDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ClientDetail> list = new ArrayList<ClientDetail>( dtos.size() );
        for ( ClientDetailDTO clientDetailDTO : dtos ) {
            list.add( toEntity( clientDetailDTO ) );
        }

        return list;
    }

    @Override
    public List<ClientDetailDTO> toDtoList(List<ClientDetail> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientDetailDTO> list = new ArrayList<ClientDetailDTO>( entities.size() );
        for ( ClientDetail clientDetail : entities ) {
            list.add( toDto( clientDetail ) );
        }

        return list;
    }
}
