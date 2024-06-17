package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.entity.User;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RoleEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T11:48:07+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class RoleDocMapperImpl implements RoleDocMapper {

    @Override
    public Role toModel(RoleEntity document) {
        if ( document == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( document.getId() );
        role.roleName( document.getRoleName() );
        role.users( userEntityListToUserList( document.getUsers() ) );

        return role.build();
    }

    @Override
    public RoleEntity toEntity(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleEntity.RoleEntityBuilder roleEntity = RoleEntity.builder();

        roleEntity.id( entity.getId() );
        roleEntity.roleName( entity.getRoleName() );
        roleEntity.users( userListToUserEntityList( entity.getUsers() ) );

        return roleEntity.build();
    }

    @Override
    public List<Role> toModelList(List<RoleEntity> documents) {
        if ( documents == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( documents.size() );
        for ( RoleEntity roleEntity : documents ) {
            list.add( toModel( roleEntity ) );
        }

        return list;
    }

    @Override
    public List<RoleEntity> toEntityList(List<Role> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RoleEntity> list = new ArrayList<RoleEntity>( entities.size() );
        for ( Role role : entities ) {
            list.add( toEntity( role ) );
        }

        return list;
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userEntity.getId() );
        user.username( userEntity.getUsername() );
        user.password( userEntity.getPassword() );
        user.roles( toModelList( userEntity.getRoles() ) );
        user.expired( userEntity.isExpired() );
        user.locked( userEntity.isLocked() );
        user.credentialsExpired( userEntity.isCredentialsExpired() );
        user.disabled( userEntity.isDisabled() );

        return user.build();
    }

    protected List<User> userEntityListToUserList(List<UserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( UserEntity userEntity : list ) {
            list1.add( userEntityToUser( userEntity ) );
        }

        return list1;
    }

    protected UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( user.getId() );
        userEntity.username( user.getUsername() );
        userEntity.password( user.getPassword() );
        userEntity.roles( toEntityList( user.getRoles() ) );
        userEntity.expired( user.isExpired() );
        userEntity.locked( user.isLocked() );
        userEntity.credentialsExpired( user.isCredentialsExpired() );
        userEntity.disabled( user.isDisabled() );

        return userEntity.build();
    }

    protected List<UserEntity> userListToUserEntityList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserEntity> list1 = new ArrayList<UserEntity>( list.size() );
        for ( User user : list ) {
            list1.add( userToUserEntity( user ) );
        }

        return list1;
    }
}
