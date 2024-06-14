package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
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
public class ClientAuthenticationMethodDocMapperImpl implements ClientAuthenticationMethodDocMapper {

    @Override
    public ClientAuthenticationMethod toModel(ClientAuthenticationMethodEntity document) {
        if ( document == null ) {
            return null;
        }

        ClientAuthenticationMethod.ClientAuthenticationMethodBuilder clientAuthenticationMethod = ClientAuthenticationMethod.builder();

        clientAuthenticationMethod.id( document.getId() );
        clientAuthenticationMethod.value( document.getValue() );
        clientAuthenticationMethod.description( document.getDescription() );

        return clientAuthenticationMethod.build();
    }

    @Override
    public ClientAuthenticationMethodEntity toEntity(ClientAuthenticationMethod entity) {
        if ( entity == null ) {
            return null;
        }

        ClientAuthenticationMethodEntity.ClientAuthenticationMethodEntityBuilder clientAuthenticationMethodEntity = ClientAuthenticationMethodEntity.builder();

        clientAuthenticationMethodEntity.id( entity.getId() );
        clientAuthenticationMethodEntity.value( entity.getValue() );
        clientAuthenticationMethodEntity.description( entity.getDescription() );

        return clientAuthenticationMethodEntity.build();
    }

    @Override
    public List<ClientAuthenticationMethod> toModelList(List<ClientAuthenticationMethodEntity> documents) {
        if ( documents == null ) {
            return null;
        }

        List<ClientAuthenticationMethod> list = new ArrayList<ClientAuthenticationMethod>( documents.size() );
        for ( ClientAuthenticationMethodEntity clientAuthenticationMethodEntity : documents ) {
            list.add( toModel( clientAuthenticationMethodEntity ) );
        }

        return list;
    }

    @Override
    public List<ClientAuthenticationMethodEntity> toEntityList(List<ClientAuthenticationMethod> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientAuthenticationMethodEntity> list = new ArrayList<ClientAuthenticationMethodEntity>( entities.size() );
        for ( ClientAuthenticationMethod clientAuthenticationMethod : entities ) {
            list.add( toEntity( clientAuthenticationMethod ) );
        }

        return list;
    }
}
