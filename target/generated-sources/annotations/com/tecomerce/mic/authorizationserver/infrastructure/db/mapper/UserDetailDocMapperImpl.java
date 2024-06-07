package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.UserDetailDocument;
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
public class UserDetailDocMapperImpl implements UserDetailDocMapper {

    @Override
    public UserDetail toEntity(UserDetailDocument document) {
        if ( document == null ) {
            return null;
        }

        UserDetail.UserDetailBuilder userDetail = UserDetail.builder();

        userDetail.id( document.getId() );
        userDetail.username( document.getUsername() );
        userDetail.password( document.getPassword() );
        userDetail.roles( roleListToRoleDTOList( document.getRoles() ) );
        userDetail.expired( document.isExpired() );
        userDetail.locked( document.isLocked() );
        userDetail.credentialsExpired( document.isCredentialsExpired() );
        userDetail.disabled( document.isDisabled() );

        return userDetail.build();
    }

    @Override
    public UserDetailDocument toDocument(UserDetail entity) {
        if ( entity == null ) {
            return null;
        }

        UserDetailDocument.UserDetailDocumentBuilder userDetailDocument = UserDetailDocument.builder();

        userDetailDocument.id( entity.getId() );
        userDetailDocument.username( entity.getUsername() );
        userDetailDocument.password( entity.getPassword() );
        userDetailDocument.roles( roleDTOListToRoleList( entity.getRoles() ) );
        userDetailDocument.expired( entity.isExpired() );
        userDetailDocument.locked( entity.isLocked() );
        userDetailDocument.credentialsExpired( entity.isCredentialsExpired() );
        userDetailDocument.disabled( entity.isDisabled() );

        return userDetailDocument.build();
    }

    @Override
    public List<UserDetail> toEntityList(List<UserDetailDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<UserDetail> list = new ArrayList<UserDetail>( documents.size() );
        for ( UserDetailDocument userDetailDocument : documents ) {
            list.add( toEntity( userDetailDocument ) );
        }

        return list;
    }

    @Override
    public List<UserDetailDocument> toDocumentList(List<UserDetail> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserDetailDocument> list = new ArrayList<UserDetailDocument>( entities.size() );
        for ( UserDetail userDetail : entities ) {
            list.add( toDocument( userDetail ) );
        }

        return list;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO.RoleDTOBuilder roleDTO = RoleDTO.builder();

        roleDTO.id( role.getId() );
        roleDTO.name( role.getName() );

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

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( roleDTO.getId() );
        role.name( roleDTO.getName() );

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
}
