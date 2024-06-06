package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleDTOMapper {

    public Role toEntity(RoleDTO dto);

    public RoleDTO toDto(Role entity);

    public List<Role> toEntityList(List<RoleDTO> dtos);

    public  List<RoleDTO> toDtoList(List<Role> entities);
}
