package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDTOMapper {

    public Client toEntity(ClientDTO dto);

    public ClientDTO toDto(Client entity);

    public List<Client> toEntityList(List<ClientDTO> dtos);

    public List<ClientDTO> toDtoList(List<Client> entities);
}
