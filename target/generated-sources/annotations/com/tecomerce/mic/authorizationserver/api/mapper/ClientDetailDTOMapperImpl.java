package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.AuthorizationGrantTypeDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.ClientAuthenticationMethodDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDetailDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.RedirectUriDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.ScopeDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.AuthorizationGrantTypeEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RedirectUriEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-13T11:24:41+0200",
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
        clientDetail.authenticationMethods( clientAuthenticationMethodDTOListToClientAuthenticationMethodEntityList( dto.getAuthenticationMethods() ) );
        clientDetail.authorizationGrantTypes( authorizationGrantTypeDTOListToAuthorizationGrantTypeEntityList( dto.getAuthorizationGrantTypes() ) );
        clientDetail.redirectUris( redirectUriDTOListToRedirectUriEntityList( dto.getRedirectUris() ) );
        clientDetail.scopes( scopeDTOListToScopeEntityList( dto.getScopes() ) );
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
        clientDetailDTO.authenticationMethods( clientAuthenticationMethodEntityListToClientAuthenticationMethodDTOList( entity.getAuthenticationMethods() ) );
        clientDetailDTO.authorizationGrantTypes( authorizationGrantTypeEntityListToAuthorizationGrantTypeDTOList( entity.getAuthorizationGrantTypes() ) );
        clientDetailDTO.redirectUris( redirectUriEntityListToRedirectUriDTOList( entity.getRedirectUris() ) );
        clientDetailDTO.scopes( scopeEntityListToScopeDTOList( entity.getScopes() ) );
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

    protected ClientAuthenticationMethodEntity clientAuthenticationMethodDTOToClientAuthenticationMethodEntity(ClientAuthenticationMethodDTO clientAuthenticationMethodDTO) {
        if ( clientAuthenticationMethodDTO == null ) {
            return null;
        }

        ClientAuthenticationMethodEntity.ClientAuthenticationMethodEntityBuilder clientAuthenticationMethodEntity = ClientAuthenticationMethodEntity.builder();

        clientAuthenticationMethodEntity.id( clientAuthenticationMethodDTO.getId() );
        clientAuthenticationMethodEntity.value( clientAuthenticationMethodDTO.getValue() );
        clientAuthenticationMethodEntity.description( clientAuthenticationMethodDTO.getDescription() );

        return clientAuthenticationMethodEntity.build();
    }

    protected List<ClientAuthenticationMethodEntity> clientAuthenticationMethodDTOListToClientAuthenticationMethodEntityList(List<ClientAuthenticationMethodDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientAuthenticationMethodEntity> list1 = new ArrayList<ClientAuthenticationMethodEntity>( list.size() );
        for ( ClientAuthenticationMethodDTO clientAuthenticationMethodDTO : list ) {
            list1.add( clientAuthenticationMethodDTOToClientAuthenticationMethodEntity( clientAuthenticationMethodDTO ) );
        }

        return list1;
    }

    protected AuthorizationGrantTypeEntity authorizationGrantTypeDTOToAuthorizationGrantTypeEntity(AuthorizationGrantTypeDTO authorizationGrantTypeDTO) {
        if ( authorizationGrantTypeDTO == null ) {
            return null;
        }

        AuthorizationGrantTypeEntity.AuthorizationGrantTypeEntityBuilder authorizationGrantTypeEntity = AuthorizationGrantTypeEntity.builder();

        authorizationGrantTypeEntity.id( authorizationGrantTypeDTO.getId() );
        authorizationGrantTypeEntity.value( authorizationGrantTypeDTO.getValue() );
        authorizationGrantTypeEntity.description( authorizationGrantTypeDTO.getDescription() );

        return authorizationGrantTypeEntity.build();
    }

    protected List<AuthorizationGrantTypeEntity> authorizationGrantTypeDTOListToAuthorizationGrantTypeEntityList(List<AuthorizationGrantTypeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AuthorizationGrantTypeEntity> list1 = new ArrayList<AuthorizationGrantTypeEntity>( list.size() );
        for ( AuthorizationGrantTypeDTO authorizationGrantTypeDTO : list ) {
            list1.add( authorizationGrantTypeDTOToAuthorizationGrantTypeEntity( authorizationGrantTypeDTO ) );
        }

        return list1;
    }

    protected RedirectUriEntity redirectUriDTOToRedirectUriEntity(RedirectUriDTO redirectUriDTO) {
        if ( redirectUriDTO == null ) {
            return null;
        }

        RedirectUriEntity.RedirectUriEntityBuilder redirectUriEntity = RedirectUriEntity.builder();

        redirectUriEntity.id( redirectUriDTO.getId() );
        redirectUriEntity.uri( redirectUriDTO.getUri() );
        redirectUriEntity.description( redirectUriDTO.getDescription() );

        return redirectUriEntity.build();
    }

    protected List<RedirectUriEntity> redirectUriDTOListToRedirectUriEntityList(List<RedirectUriDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<RedirectUriEntity> list1 = new ArrayList<RedirectUriEntity>( list.size() );
        for ( RedirectUriDTO redirectUriDTO : list ) {
            list1.add( redirectUriDTOToRedirectUriEntity( redirectUriDTO ) );
        }

        return list1;
    }

    protected ScopeEntity scopeDTOToScopeEntity(ScopeDTO scopeDTO) {
        if ( scopeDTO == null ) {
            return null;
        }

        ScopeEntity.ScopeEntityBuilder scopeEntity = ScopeEntity.builder();

        scopeEntity.id( scopeDTO.getId() );
        scopeEntity.name( scopeDTO.getName() );
        scopeEntity.description( scopeDTO.getDescription() );

        return scopeEntity.build();
    }

    protected List<ScopeEntity> scopeDTOListToScopeEntityList(List<ScopeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ScopeEntity> list1 = new ArrayList<ScopeEntity>( list.size() );
        for ( ScopeDTO scopeDTO : list ) {
            list1.add( scopeDTOToScopeEntity( scopeDTO ) );
        }

        return list1;
    }

    protected ClientAuthenticationMethodDTO clientAuthenticationMethodEntityToClientAuthenticationMethodDTO(ClientAuthenticationMethodEntity clientAuthenticationMethodEntity) {
        if ( clientAuthenticationMethodEntity == null ) {
            return null;
        }

        ClientAuthenticationMethodDTO.ClientAuthenticationMethodDTOBuilder clientAuthenticationMethodDTO = ClientAuthenticationMethodDTO.builder();

        clientAuthenticationMethodDTO.id( clientAuthenticationMethodEntity.getId() );
        clientAuthenticationMethodDTO.value( clientAuthenticationMethodEntity.getValue() );
        clientAuthenticationMethodDTO.description( clientAuthenticationMethodEntity.getDescription() );

        return clientAuthenticationMethodDTO.build();
    }

    protected List<ClientAuthenticationMethodDTO> clientAuthenticationMethodEntityListToClientAuthenticationMethodDTOList(List<ClientAuthenticationMethodEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientAuthenticationMethodDTO> list1 = new ArrayList<ClientAuthenticationMethodDTO>( list.size() );
        for ( ClientAuthenticationMethodEntity clientAuthenticationMethodEntity : list ) {
            list1.add( clientAuthenticationMethodEntityToClientAuthenticationMethodDTO( clientAuthenticationMethodEntity ) );
        }

        return list1;
    }

    protected AuthorizationGrantTypeDTO authorizationGrantTypeEntityToAuthorizationGrantTypeDTO(AuthorizationGrantTypeEntity authorizationGrantTypeEntity) {
        if ( authorizationGrantTypeEntity == null ) {
            return null;
        }

        AuthorizationGrantTypeDTO.AuthorizationGrantTypeDTOBuilder authorizationGrantTypeDTO = AuthorizationGrantTypeDTO.builder();

        authorizationGrantTypeDTO.id( authorizationGrantTypeEntity.getId() );
        authorizationGrantTypeDTO.value( authorizationGrantTypeEntity.getValue() );
        authorizationGrantTypeDTO.description( authorizationGrantTypeEntity.getDescription() );

        return authorizationGrantTypeDTO.build();
    }

    protected List<AuthorizationGrantTypeDTO> authorizationGrantTypeEntityListToAuthorizationGrantTypeDTOList(List<AuthorizationGrantTypeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AuthorizationGrantTypeDTO> list1 = new ArrayList<AuthorizationGrantTypeDTO>( list.size() );
        for ( AuthorizationGrantTypeEntity authorizationGrantTypeEntity : list ) {
            list1.add( authorizationGrantTypeEntityToAuthorizationGrantTypeDTO( authorizationGrantTypeEntity ) );
        }

        return list1;
    }

    protected RedirectUriDTO redirectUriEntityToRedirectUriDTO(RedirectUriEntity redirectUriEntity) {
        if ( redirectUriEntity == null ) {
            return null;
        }

        RedirectUriDTO.RedirectUriDTOBuilder redirectUriDTO = RedirectUriDTO.builder();

        redirectUriDTO.id( redirectUriEntity.getId() );
        redirectUriDTO.uri( redirectUriEntity.getUri() );
        redirectUriDTO.description( redirectUriEntity.getDescription() );

        return redirectUriDTO.build();
    }

    protected List<RedirectUriDTO> redirectUriEntityListToRedirectUriDTOList(List<RedirectUriEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<RedirectUriDTO> list1 = new ArrayList<RedirectUriDTO>( list.size() );
        for ( RedirectUriEntity redirectUriEntity : list ) {
            list1.add( redirectUriEntityToRedirectUriDTO( redirectUriEntity ) );
        }

        return list1;
    }

    protected ScopeDTO scopeEntityToScopeDTO(ScopeEntity scopeEntity) {
        if ( scopeEntity == null ) {
            return null;
        }

        ScopeDTO.ScopeDTOBuilder scopeDTO = ScopeDTO.builder();

        scopeDTO.id( scopeEntity.getId() );
        scopeDTO.name( scopeEntity.getName() );
        scopeDTO.description( scopeEntity.getDescription() );

        return scopeDTO.build();
    }

    protected List<ScopeDTO> scopeEntityListToScopeDTOList(List<ScopeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ScopeDTO> list1 = new ArrayList<ScopeDTO>( list.size() );
        for ( ScopeEntity scopeEntity : list ) {
            list1.add( scopeEntityToScopeDTO( scopeEntity ) );
        }

        return list1;
    }
}
