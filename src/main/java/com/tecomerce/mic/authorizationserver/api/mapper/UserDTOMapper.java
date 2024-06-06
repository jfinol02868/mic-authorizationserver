package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.UserDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    public User toEntity(UserDTO dto);

    public UserDTO toDto(User entity);

    public List<User> toEntityList(List<UserDTO> dtos);

    public  List<UserDTO> toDtoList(List<User> entities);
}
