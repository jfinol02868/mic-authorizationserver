package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RoleDocument;
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
public class RoleDocMapperImpl implements RoleDocMapper {

    @Override
    public Role toEntity(RoleDocument document) {
        if ( document == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( document.getId() );
        role.name( document.getName() );

        return role.build();
    }

    @Override
    public RoleDocument toDocument(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleDocument.RoleDocumentBuilder roleDocument = RoleDocument.builder();

        roleDocument.id( entity.getId() );
        roleDocument.name( entity.getName() );

        return roleDocument.build();
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
}
