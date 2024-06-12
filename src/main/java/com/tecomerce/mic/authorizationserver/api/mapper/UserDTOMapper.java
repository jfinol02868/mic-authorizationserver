package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.UserDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOMapper {

    public static User toEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .roles(toRoleEntityList(dto.getRoles()))
                .expired(dto.isExpired())
                .locked(dto.isLocked())
                .credentialsExpired(dto.isCredentialsExpired())
                .disabled(dto.isDisabled())
                .build();
    }

    private static List<Role> toRoleEntityList(List<String> roles){
        return roles.stream().map(role -> Role.builder()
                .id(role)
                .build()).collect(Collectors.toList());
    }

    public static UserDTO toDto(User entity){
        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .roles(toRoleList(entity.getRoles()))
                .expired(entity.isExpired())
                .locked(entity.isLocked())
                .credentialsExpired(entity.isCredentialsExpired())
                .disabled(entity.isDisabled())
                .build();
    }

    private static List<String> toRoleList(List<Role> roles) {
        return roles.stream().map(Role::getId).collect(Collectors.toList());
    }

    public static List<User> toEntityList(List<UserDTO> dtos) {
        return dtos.stream().map(UserDTOMapper::toEntity).collect(Collectors.toList());
    }

    public static List<UserDTO> toDtoList(List<User> entities) {
        return entities.stream().map(UserDTOMapper::toDto).collect(Collectors.toList());
    }
}
