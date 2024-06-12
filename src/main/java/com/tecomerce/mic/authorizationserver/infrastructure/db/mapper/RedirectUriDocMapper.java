package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RedirectUriEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RedirectUriDocMapper {

    public RedirectUri toModel(RedirectUriEntity document);

    public RedirectUriEntity toEntity(RedirectUri entity);

    public List<RedirectUri> toModelList(List<RedirectUriEntity> documents);

    public List<RedirectUriEntity> toEntityList(List<RedirectUri> entities);
}
