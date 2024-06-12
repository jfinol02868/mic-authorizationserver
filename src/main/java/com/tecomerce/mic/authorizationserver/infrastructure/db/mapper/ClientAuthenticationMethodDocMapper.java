package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientAuthenticationMethodDocMapper {

    public ClientAuthenticationMethod toModel(ClientAuthenticationMethodEntity document);

    public ClientAuthenticationMethodEntity toEntity(ClientAuthenticationMethod entity);

    public List<ClientAuthenticationMethod> toModelList(List<ClientAuthenticationMethodEntity> documents);

    public List<ClientAuthenticationMethodEntity> toEntityList(List<ClientAuthenticationMethod> entities);
}
