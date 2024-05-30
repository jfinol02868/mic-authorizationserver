package com.tecomerce.mic.authorizationserver.repository.mapper;

import com.tecomerce.mic.authorizationserver.repository.document.UserDocument;
import com.tecomerce.mic.authorizationserver.service.entity.User;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDocument toDocument(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDocument.UserDocumentBuilder userDocument = UserDocument.builder();

        userDocument.id( entity.getId() );
        userDocument.username( entity.getUsername() );
        userDocument.password( entity.getPassword() );
        userDocument.email( entity.getEmail() );
        userDocument.enabled( entity.isEnabled() );
        List<String> list = entity.getRoles();
        if ( list != null ) {
            userDocument.roles( new ArrayList<String>( list ) );
        }

        return userDocument.build();
    }

    @Override
    public User toEntity(UserDocument document) {
        if ( document == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( document.getId() );
        user.username( document.getUsername() );
        user.password( document.getPassword() );
        user.email( document.getEmail() );
        user.enabled( document.isEnabled() );
        List<String> list = document.getRoles();
        if ( list != null ) {
            user.roles( new ArrayList<String>( list ) );
        }

        return user.build();
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
}
