package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.AuthorizationGrantTypeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-13T11:24:42+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class AuthorizationGrantTypeDocMapperImpl implements AuthorizationGrantTypeDocMapper {

    @Override
    public AuthorizationGrantType toModel(AuthorizationGrantTypeEntity document) {
        if ( document == null ) {
            return null;
        }

        AuthorizationGrantType.AuthorizationGrantTypeBuilder authorizationGrantType = AuthorizationGrantType.builder();

        authorizationGrantType.id( document.getId() );
        authorizationGrantType.value( document.getValue() );
        authorizationGrantType.description( document.getDescription() );

        return authorizationGrantType.build();
    }

    @Override
    public AuthorizationGrantTypeEntity toEntity(AuthorizationGrantType entity) {
        if ( entity == null ) {
            return null;
        }

        AuthorizationGrantTypeEntity.AuthorizationGrantTypeEntityBuilder authorizationGrantTypeEntity = AuthorizationGrantTypeEntity.builder();

        authorizationGrantTypeEntity.id( entity.getId() );
        authorizationGrantTypeEntity.value( entity.getValue() );
        authorizationGrantTypeEntity.description( entity.getDescription() );

        return authorizationGrantTypeEntity.build();
    }

    @Override
    public List<AuthorizationGrantType> toModelList(List<AuthorizationGrantTypeEntity> documents) {
        if ( documents == null ) {
            return null;
        }

        List<AuthorizationGrantType> list = new ArrayList<AuthorizationGrantType>( documents.size() );
        for ( AuthorizationGrantTypeEntity authorizationGrantTypeEntity : documents ) {
            list.add( toModel( authorizationGrantTypeEntity ) );
        }

        return list;
    }

    @Override
    public List<AuthorizationGrantTypeEntity> toEntityList(List<AuthorizationGrantType> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AuthorizationGrantTypeEntity> list = new ArrayList<AuthorizationGrantTypeEntity>( entities.size() );
        for ( AuthorizationGrantType authorizationGrantType : entities ) {
            list.add( toEntity( authorizationGrantType ) );
        }

        return list;
    }
}
