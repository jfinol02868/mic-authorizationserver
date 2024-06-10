package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.User;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.UserDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T14:53:44+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserDocMapperImpl implements UserDocMapper {

    @Override
    public User toEntity(UserDocument document) {
        if ( document == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( document.getId() );
        user.username( document.getUsername() );
        user.password( document.getPassword() );
        List<String> list = document.getRoles();
        if ( list != null ) {
            user.roles( new ArrayList<String>( list ) );
        }
        user.expired( document.isExpired() );
        user.locked( document.isLocked() );
        user.credentialsExpired( document.isCredentialsExpired() );
        user.disabled( document.isDisabled() );

        return user.build();
    }

    @Override
    public UserDocument toDocument(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDocument.UserDocumentBuilder userDocument = UserDocument.builder();

        userDocument.id( entity.getId() );
        userDocument.username( entity.getUsername() );
        userDocument.password( entity.getPassword() );
        List<String> list = entity.getRoles();
        if ( list != null ) {
            userDocument.roles( new ArrayList<String>( list ) );
        }
        userDocument.expired( entity.isExpired() );
        userDocument.locked( entity.isLocked() );
        userDocument.credentialsExpired( entity.isCredentialsExpired() );
        userDocument.disabled( entity.isDisabled() );

        return userDocument.build();
    }

    @Override
    public List<User> toEntityList(List<UserDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( documents.size() );
        for ( UserDocument userDocument : documents ) {
            list.add( toEntity( userDocument ) );
        }

        return list;
    }

    @Override
    public List<UserDocument> toDocumentList(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserDocument> list = new ArrayList<UserDocument>( entities.size() );
        for ( User user : entities ) {
            list.add( toDocument( user ) );
        }

        return list;
    }
}
