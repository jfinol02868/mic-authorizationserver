package com.tecomerce.mic.authorizationserver.controller.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.UserDTO;
import com.tecomerce.mic.authorizationserver.controller.service.dto.UserDetailDTO;
import com.tecomerce.mic.authorizationserver.service.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailDtoMapper {

    public UserDetailDTO toDto(User entity);

    public User toEntity(UserDetailDTO dto);

    public List<UserDetailDTO> toDtoList(List<User> entities);

    public List<User> toEntityList(List<UserDetailDTO> dtos);
}
