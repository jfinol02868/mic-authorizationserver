package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDocMapper {

    Client toModel(ClientEntity client);

    ClientEntity toEntity(Client model);

    List<Client> toModelList(List<ClientEntity> entities);

    List<ClientEntity> toEntityList(List<Client> models);
}
