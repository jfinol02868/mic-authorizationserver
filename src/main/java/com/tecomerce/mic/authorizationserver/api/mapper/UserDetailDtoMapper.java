package com.tecomerce.mic.authorizationserver.api.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.UserDetailDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailDtoMapper {

    public UserDetail toEntity(UserDetailDTO document);

    public UserDetailDTO toDto(UserDetail entity);

    public List<UserDetail> toEntityList(List<UserDetailDTO> documents);

    public  List<UserDetailDTO> toDtoList(List<UserDetail> entities);


}
