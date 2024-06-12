package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleDocMapper {

    public Role toModel(RoleEntity document);

    public RoleEntity toEntity(Role entity);

    public List<Role> toModelList(List<RoleEntity> documents);

    public  List<RoleEntity> toEntityList(List<Role> entities);
}
