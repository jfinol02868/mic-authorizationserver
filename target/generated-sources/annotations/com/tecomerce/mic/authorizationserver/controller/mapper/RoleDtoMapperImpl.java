package com.tecomerce.mic.authorizationserver.controller.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.service.entity.Role;
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
public class RoleDtoMapperImpl implements RoleDtoMapper {

    @Override
    public RoleDTO toDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDTO.RoleDTOBuilder roleDTO = RoleDTO.builder();

        roleDTO.id( entity.getId() );
        roleDTO.name( entity.getName() );
        List<String> list = entity.getAuthorities();
        if ( list != null ) {
            roleDTO.authorities( new ArrayList<String>( list ) );
        }

        return roleDTO.build();
    }

    @Override
    public Role toEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( dto.getId() );
        role.setName( dto.getName() );
        List<String> list = dto.getAuthorities();
        if ( list != null ) {
            role.setAuthorities( new ArrayList<String>( list ) );
        }

        return role;
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
}
