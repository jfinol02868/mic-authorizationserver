package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ScopeDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScopeDTOMapper {

    public Scope toEntity(ScopeDTO dto);

    public ScopeDTO toDto(Scope entity);

    public List<Scope> toEntityList(List<ScopeDTO> dtos);

    public List<ScopeDTO> toDtoList(List<Scope> entities);
}
