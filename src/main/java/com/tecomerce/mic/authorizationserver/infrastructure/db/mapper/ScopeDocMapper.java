package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScopeDocMapper {

    public Scope toModel(ScopeEntity dto);

    public ScopeEntity toEntity(Scope entity);

    public List<Scope> toModelList(List<ScopeEntity> dtos);

    public List<ScopeEntity> toEntityList(List<Scope> entities);
}
