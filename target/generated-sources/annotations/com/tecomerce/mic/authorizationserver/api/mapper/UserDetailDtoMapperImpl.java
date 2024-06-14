package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.UserDetailDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T10:40:17+0200",
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
        userDetail.roles( roleDTOListToRoleList( document.getRoles() ) );
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
        userDetailDTO.roles( roleListToRoleDTOList( entity.getRoles() ) );
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

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( roleDTO.getId() );
        role.roleName( roleDTO.getRoleName() );

        return role.build();
    }

    protected List<Role> roleDTOListToRoleList(List<RoleDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( RoleDTO roleDTO : list ) {
            list1.add( roleDTOToRole( roleDTO ) );
        }

        return list1;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO.RoleDTOBuilder roleDTO = RoleDTO.builder();

        roleDTO.id( role.getId() );
        roleDTO.roleName( role.getRoleName() );

        return roleDTO.build();
    }

    protected List<RoleDTO> roleListToRoleDTOList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleDTO> list1 = new ArrayList<RoleDTO>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleDTO( role ) );
        }

        return list1;
    }
}
