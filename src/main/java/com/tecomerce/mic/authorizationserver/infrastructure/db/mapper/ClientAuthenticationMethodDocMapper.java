package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientAuthenticationMethodDocMapper {

    ClientAuthenticationMethod toModel(ClientAuthenticationMethodEntity document);

    ClientAuthenticationMethodEntity toEntity(ClientAuthenticationMethod entity);

    List<ClientAuthenticationMethod> toModelList(List<ClientAuthenticationMethodEntity> documents);

    List<ClientAuthenticationMethodEntity> toEntityList(List<ClientAuthenticationMethod> entities);
}
