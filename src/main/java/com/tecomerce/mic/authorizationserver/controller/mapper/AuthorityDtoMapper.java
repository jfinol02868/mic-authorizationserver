package com.tecomerce.mic.authorizationserver.controller.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.AuthorityDTO;
import com.tecomerce.mic.authorizationserver.service.entity.Authority;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorityDtoMapper {

    public AuthorityDTO toDto(Authority entity);

    public Authority toEntity(AuthorityDTO dto);

    public List<AuthorityDTO> toDtoList(List<Authority> entities);

    public List<Authority> toEntityList(List<AuthorityDTO> dtos);

}
