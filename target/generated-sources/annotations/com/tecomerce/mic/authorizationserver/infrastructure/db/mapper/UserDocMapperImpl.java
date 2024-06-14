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
    date = "2024-06-14T12:59:39+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserDocMapperImpl implements UserDocMapper {

    @Override
    public User toModel(UserEntity document) {
        if ( document == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( document.getId() );
        user.username( document.getUsername() );
        user.password( document.getPassword() );
        user.roles( roleEntityListToRoleList( document.getRoles() ) );
        user.expired( document.isExpired() );
        user.locked( document.isLocked() );
        user.credentialsExpired( document.isCredentialsExpired() );
        user.disabled( document.isDisabled() );

        return user.build();
    }

    @Override
    public UserEntity toEntity(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( entity.getId() );
        userEntity.username( entity.getUsername() );
        userEntity.password( entity.getPassword() );
        userEntity.roles( roleListToRoleEntityList( entity.getRoles() ) );
        userEntity.expired( entity.isExpired() );
        userEntity.locked( entity.isLocked() );
        userEntity.credentialsExpired( entity.isCredentialsExpired() );
        userEntity.disabled( entity.isDisabled() );

        return userEntity.build();
    }

    @Override
    public List<User> toModelList(List<UserEntity> documents) {
        if ( documents == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( documents.size() );
        for ( UserEntity userEntity : documents ) {
            list.add( toModel( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toEntityList(List<User> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( entities.size() );
        for ( User user : entities ) {
            list.add( toEntity( user ) );
        }

        return list;
    }

    protected Role roleEntityToRole(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( roleEntity.getId() );
        role.roleName( roleEntity.getRoleName() );
        role.users( toModelList( roleEntity.getUsers() ) );

        return role.build();
    }

    protected List<Role> roleEntityListToRoleList(List<RoleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( RoleEntity roleEntity : list ) {
            list1.add( roleEntityToRole( roleEntity ) );
        }

        return list1;
    }

    protected RoleEntity roleToRoleEntity(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleEntity.RoleEntityBuilder roleEntity = RoleEntity.builder();

        roleEntity.id( role.getId() );
        roleEntity.roleName( role.getRoleName() );
        roleEntity.users( toEntityList( role.getUsers() ) );

        return roleEntity.build();
    }

    protected List<RoleEntity> roleListToRoleEntityList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleEntity> list1 = new ArrayList<RoleEntity>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleEntity( role ) );
        }

        return list1;
    }
}
