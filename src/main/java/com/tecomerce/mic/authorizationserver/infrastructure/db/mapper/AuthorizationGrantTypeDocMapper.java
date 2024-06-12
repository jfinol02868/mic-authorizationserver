package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.AuthorizationGrantTypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorizationGrantTypeDocMapper {

    public AuthorizationGrantType toModel(AuthorizationGrantTypeEntity document);

    public AuthorizationGrantTypeEntity toEntity(AuthorizationGrantType entity);

    public List<AuthorizationGrantType> toModelList(List<AuthorizationGrantTypeEntity> documents);

    public List<AuthorizationGrantTypeEntity> toEntityList(List<AuthorizationGrantType> entities);
}
