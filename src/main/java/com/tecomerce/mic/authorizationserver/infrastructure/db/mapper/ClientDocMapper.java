package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDocMapper {

    public Client toModel(ClientEntity client);

    public ClientEntity toEntity(Client model);

    public List<Client> toModelList(List<ClientEntity> entities);

    public List<ClientEntity> toEntityList(List<Client> models);
}
