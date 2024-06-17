package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T12:13:59+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class RoleDTOMapperImpl implements RoleDTOMapper {

    @Override
    public Role toEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( dto.getId() );
        role.roleName( dto.getRoleName() );

        return role.build();
    }

    @Override
    public RoleDTO toDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO.RoleDTOBuilder roleDTO = RoleDTO.builder();

        roleDTO.id( entity.getId() );
        roleDTO.roleName( entity.getRoleName() );

        return roleDTO.build();
    }

    @Override
    public List<Role> toEntityList(List<RoleDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( dtos.size() );
        for ( RoleDTO roleDTO : dtos ) {
            list.add( toEntity( roleDTO ) );
        }

        return list;
    }

    @Override
    public List<RoleDTO> toDtoList(List<Role> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( entities.size() );
        for ( Role role : entities ) {
            list.add( toDto( role ) );
        }

        return list;
    }
}
