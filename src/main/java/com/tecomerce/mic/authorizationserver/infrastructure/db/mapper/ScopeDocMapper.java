package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScopeDocMapper {

    Scope toModel(ScopeEntity dto);

    ScopeEntity toEntity(Scope entity);

    List<Scope> toModelList(List<ScopeEntity> dtos);

    List<ScopeEntity> toEntityList(List<Scope> entities);
}
