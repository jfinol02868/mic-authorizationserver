package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T19:16:25+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ClientAuthenticationMethodDocMapperImpl implements ClientAuthenticationMethodDocMapper {

    @Override
    public ClientAuthenticationMethod toEntity(ClientAuthenticationMethodDocument document) {
        if ( document == null ) {
            return null;
        }

        ClientAuthenticationMethod.ClientAuthenticationMethodBuilder clientAuthenticationMethod = ClientAuthenticationMethod.builder();

        clientAuthenticationMethod.id( document.getId() );
        clientAuthenticationMethod.name( document.getName() );
        clientAuthenticationMethod.description( document.getDescription() );

        return clientAuthenticationMethod.build();
    }

    @Override
    public ClientAuthenticationMethodDocument toDocument(ClientAuthenticationMethod entity) {
        if ( entity == null ) {
            return null;
        }

        ClientAuthenticationMethodDocument.ClientAuthenticationMethodDocumentBuilder clientAuthenticationMethodDocument = ClientAuthenticationMethodDocument.builder();

        clientAuthenticationMethodDocument.id( entity.getId() );
        clientAuthenticationMethodDocument.name( entity.getName() );
        clientAuthenticationMethodDocument.description( entity.getDescription() );

        return clientAuthenticationMethodDocument.build();
    }

    @Override
    public List<ClientAuthenticationMethod> toEntityList(List<ClientAuthenticationMethodDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<ClientAuthenticationMethod> list = new ArrayList<ClientAuthenticationMethod>( documents.size() );
        for ( ClientAuthenticationMethodDocument clientAuthenticationMethodDocument : documents ) {
            list.add( toEntity( clientAuthenticationMethodDocument ) );
        }

        return list;
    }

    @Override
    public List<ClientAuthenticationMethodDocument> toDocumentList(List<ClientAuthenticationMethod> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ClientAuthenticationMethodDocument> list = new ArrayList<ClientAuthenticationMethodDocument>( entities.size() );
        for ( ClientAuthenticationMethod clientAuthenticationMethod : entities ) {
            list.add( toDocument( clientAuthenticationMethod ) );
        }

        return list;
    }
}
