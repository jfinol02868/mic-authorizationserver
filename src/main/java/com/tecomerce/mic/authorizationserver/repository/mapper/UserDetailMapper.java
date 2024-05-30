package com.tecomerce.mic.authorizationserver.repository.mapper;

import com.tecomerce.mic.authorizationserver.controller.service.dto.UserDetailDTO;
import com.tecomerce.mic.authorizationserver.repository.document.UserDetailDocument;
import com.tecomerce.mic.authorizationserver.service.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailMapper {

    public UserDetailDocument toDocument(User entity);

    public User toEntity(UserDetailDocument document);

    public List<UserDetailDocument> toDocumentList(List<User> entities);

    public List<User> toEntityList(List<UserDetailDocument> documents);
}
