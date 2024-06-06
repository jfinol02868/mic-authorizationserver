package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.UserDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T20:44:56+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserDTOMapperImpl implements UserDTOMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.username( dto.getUsername() );
        user.password( dto.getPassword() );
        List<String> list = dto.getRoles();
        if ( list != null ) {
            user.roles( new ArrayList<String>( list ) );
        }
        user.expired( dto.isExpired() );
        user.locked( dto.isLocked() );
        user.credentialsExpired( dto.isCredentialsExpired() );
        user.disabled( dto.isDisabled() );

        return user.build();
    }

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( entity.getId() );
        userDTO.username( entity.getUsername() );
        userDTO.password( entity.getPassword() );
        List<String> list = entity.getRoles();
        if ( list != null ) {
            userDTO.roles( new ArrayList<String>( list ) );
        }
        userDTO.expired( entity.isExpired() );
        userDTO.locked( entity.isLocked() );
        userDTO.credentialsExpired( entity.isCredentialsExpired() );
        userDTO.disabled( entity.isDisabled() );

        return userDTO.build();
    }

    @Override
    public List<User> toEntityList(List<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDTO userDTO : dtos ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDtoList(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entities.size() );
        for ( User user : entities ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
