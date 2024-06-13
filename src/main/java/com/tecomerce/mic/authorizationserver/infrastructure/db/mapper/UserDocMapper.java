package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.User;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDocMapper {

    User toModel(UserEntity document);

    UserEntity toEntity(User entity);

    List<User> toModelList(List<UserEntity> documents);

    List<UserEntity> toEntityList(List<User> entities);
}
