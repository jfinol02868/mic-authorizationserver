package com.tecomerce.mic.authorizationserver.controller.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.repository.document.RoleDocument;
import com.tecomerce.mic.authorizationserver.service.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleDtoMapper {

    public RoleDTO toDto(Role entity);

    public Role toEntity(RoleDTO dto);

    public List<RoleDTO> toDtoList(List<Role> entities);

    public List<Role> toEntityList(List<RoleDTO> dtos);

}
