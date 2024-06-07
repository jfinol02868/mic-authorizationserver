package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RedirectUriDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RedirectUriDTOMapper {

    public RedirectUri toEntity(RedirectUriDTO dto);

    public RedirectUriDTO toDto(RedirectUri entity);

    public List<RedirectUri> toEntityList(List<RedirectUriDTO> dtos);

    public List<RedirectUriDTO> toDtoList(List<RedirectUri> entities);
}
