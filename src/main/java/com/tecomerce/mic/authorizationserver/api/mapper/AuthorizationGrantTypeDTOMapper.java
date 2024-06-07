package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.AuthorizationGrantTypeDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorizationGrantTypeDTOMapper {

    public AuthorizationGrantType toEntity(AuthorizationGrantTypeDTO dto);

    public AuthorizationGrantTypeDTO toDto(AuthorizationGrantType entity);

    public List<AuthorizationGrantType> toEntityList(List<AuthorizationGrantTypeDTO> dtos);

    public List<AuthorizationGrantTypeDTO> toDtoList(List<AuthorizationGrantType> entities);
}
