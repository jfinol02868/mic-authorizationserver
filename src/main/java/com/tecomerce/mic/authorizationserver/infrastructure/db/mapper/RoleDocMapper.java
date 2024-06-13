package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleDocMapper {

    Role toModel(RoleEntity document);

    RoleEntity toEntity(Role entity);

    List<Role> toModelList(List<RoleEntity> documents);

    List<RoleEntity> toEntityList(List<Role> entities);
}
