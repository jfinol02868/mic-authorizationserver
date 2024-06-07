package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDetailDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDetailDTOMapper {

    public ClientDetail toEntity(ClientDetailDTO dto);

    public ClientDetailDTO toDto(ClientDetail entity);

    public List<ClientDetail> toEntityList(List<ClientDetailDTO> dtos);

    public List<ClientDetailDTO> toDtoList(List<ClientDetail> entities);
}
