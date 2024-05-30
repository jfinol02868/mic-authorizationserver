package com.tecomerce.mic.authorizationserver.controller.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.UserDTO;
import com.tecomerce.mic.authorizationserver.repository.document.UserDocument;
import com.tecomerce.mic.authorizationserver.service.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    public UserDTO toDto(User entity);

    public User toEntity(UserDTO dto);

    public List<UserDTO> toDtoList(List<User> entities);

    public List<User> toEntityList(List<UserDTO> dtos);
}
