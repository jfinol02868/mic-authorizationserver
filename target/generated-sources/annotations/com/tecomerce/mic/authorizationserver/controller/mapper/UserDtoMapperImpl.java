package com.tecomerce.mic.authorizationserver.controller.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.UserDTO;
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
public class UserDtoMapperImpl implements UserDtoMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( entity.getId() );
        userDTO.username( entity.getUsername() );
        userDTO.password( entity.getPassword() );
        userDTO.email( entity.getEmail() );
        userDTO.enabled( entity.isEnabled() );
        List<String> list = entity.getRoles();
        if ( list != null ) {
            userDTO.roles( new ArrayList<String>( list ) );
        }

        return userDTO.build();
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.username( dto.getUsername() );
        user.password( dto.getPassword() );
        user.email( dto.getEmail() );
        user.enabled( dto.isEnabled() );
        List<String> list = dto.getRoles();
        if ( list != null ) {
            user.roles( new ArrayList<String>( list ) );
        }

        return user.build();
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
}
