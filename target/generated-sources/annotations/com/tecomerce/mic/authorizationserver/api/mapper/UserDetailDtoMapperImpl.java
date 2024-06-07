package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.UserDetailDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T17:33:56+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserDetailDtoMapperImpl implements UserDetailDtoMapper {

    @Override
    public UserDetail toEntity(UserDetailDTO document) {
        if ( document == null ) {
            return null;
        }

        UserDetail.UserDetailBuilder userDetail = UserDetail.builder();

        userDetail.id( document.getId() );
        userDetail.username( document.getUsername() );
        userDetail.password( document.getPassword() );
        List<RoleDTO> list = document.getRoles();
        if ( list != null ) {
            userDetail.roles( new ArrayList<RoleDTO>( list ) );
        }
        userDetail.expired( document.isExpired() );
        userDetail.locked( document.isLocked() );
        userDetail.credentialsExpired( document.isCredentialsExpired() );
        userDetail.disabled( document.isDisabled() );

        return userDetail.build();
    }

    @Override
    public UserDetailDTO toDto(UserDetail entity) {
        if ( entity == null ) {
            return null;
        }

        UserDetailDTO.UserDetailDTOBuilder userDetailDTO = UserDetailDTO.builder();

        userDetailDTO.id( entity.getId() );
        userDetailDTO.username( entity.getUsername() );
        userDetailDTO.password( entity.getPassword() );
        List<RoleDTO> list = entity.getRoles();
        if ( list != null ) {
            userDetailDTO.roles( new ArrayList<RoleDTO>( list ) );
        }
        userDetailDTO.expired( entity.isExpired() );
        userDetailDTO.locked( entity.isLocked() );
        userDetailDTO.credentialsExpired( entity.isCredentialsExpired() );
        userDetailDTO.disabled( entity.isDisabled() );

        return userDetailDTO.build();
    }

    @Override
    public List<UserDetail> toEntityList(List<UserDetailDTO> documents) {
        if ( documents == null ) {
            return null;
        }

        List<UserDetail> list = new ArrayList<UserDetail>( documents.size() );
        for ( UserDetailDTO userDetailDTO : documents ) {
            list.add( toEntity( userDetailDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDetailDTO> toDtoList(List<UserDetail> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserDetailDTO> list = new ArrayList<UserDetailDTO>( entities.size() );
        for ( UserDetail userDetail : entities ) {
            list.add( toDto( userDetail ) );
        }

        return list;
    }
}
