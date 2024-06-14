package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RedirectUriEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T12:59:38+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class RedirectUriDocMapperImpl implements RedirectUriDocMapper {

    @Override
    public RedirectUri toModel(RedirectUriEntity document) {
        if ( document == null ) {
            return null;
        }

        RedirectUri.RedirectUriBuilder redirectUri = RedirectUri.builder();

        redirectUri.id( document.getId() );
        redirectUri.uri( document.getUri() );
        redirectUri.description( document.getDescription() );

        return redirectUri.build();
    }

    @Override
    public RedirectUriEntity toEntity(RedirectUri entity) {
        if ( entity == null ) {
            return null;
        }

        RedirectUriEntity.RedirectUriEntityBuilder redirectUriEntity = RedirectUriEntity.builder();

        redirectUriEntity.id( entity.getId() );
        redirectUriEntity.uri( entity.getUri() );
        redirectUriEntity.description( entity.getDescription() );

        return redirectUriEntity.build();
    }

    @Override
    public List<RedirectUri> toModelList(List<RedirectUriEntity> documents) {
        if ( documents == null ) {
            return null;
        }

        List<RedirectUri> list = new ArrayList<RedirectUri>( documents.size() );
        for ( RedirectUriEntity redirectUriEntity : documents ) {
            list.add( toModel( redirectUriEntity ) );
        }

        return list;
    }

    @Override
    public List<RedirectUriEntity> toEntityList(List<RedirectUri> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RedirectUriEntity> list = new ArrayList<RedirectUriEntity>( entities.size() );
        for ( RedirectUri redirectUri : entities ) {
            list.add( toEntity( redirectUri ) );
        }

        return list;
    }
}
