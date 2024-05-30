package com.tecomerce.mic.authorizationserver.repository.mapper;

import com.tecomerce.mic.authorizationserver.repository.document.RoleDocument;
import com.tecomerce.mic.authorizationserver.service.entity.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-29T17:14:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDocument toDocument(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDocument.RoleDocumentBuilder roleDocument = RoleDocument.builder();

        roleDocument.id( entity.getId() );
        roleDocument.name( entity.getName() );
        List<String> list = entity.getAuthorities();
        if ( list != null ) {
            roleDocument.authorities( new ArrayList<String>( list ) );
        }

        return roleDocument.build();
    }

    @Override
    public Role toEntity(RoleDocument document) {
        if ( document == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( document.getId() );
        role.setName( document.getName() );
        List<String> list = document.getAuthorities();
        if ( list != null ) {
            role.setAuthorities( new ArrayList<String>( list ) );
        }

        return role;
    }

    @Override
    public List<RoleDocument> toDocumentList(List<Role> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RoleDocument> list = new ArrayList<RoleDocument>( entities.size() );
        for ( Role role : entities ) {
            list.add( toDocument( role ) );
        }

        return list;
    }

    @Override
    public List<Role> toEntityList(List<RoleDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( documents.size() );
        for ( RoleDocument roleDocument : documents ) {
            list.add( toEntity( roleDocument ) );
        }

        return list;
    }
}
