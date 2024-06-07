package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientAuthenticationMethodDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientAuthenticationMethodDTOMapper {

    public ClientAuthenticationMethod toEntity(ClientAuthenticationMethodDTO dto);

    public ClientAuthenticationMethodDTO toDto(ClientAuthenticationMethod entity);

    public List<ClientAuthenticationMethod> toEntityList(List<ClientAuthenticationMethodDTO> dtos);

    public List<ClientAuthenticationMethodDTO> toDtoList(List<ClientAuthenticationMethod> entities);
}
