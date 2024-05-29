package com.tecomerce.mic.authorizationserver.repository.mapper;

import com.tecomerce.mic.authorizationserver.repository.document.AuthorityDocument;
import com.tecomerce.mic.authorizationserver.repository.document.RoleDocument;
import com.tecomerce.mic.authorizationserver.repository.document.UserDocument;
import com.tecomerce.mic.authorizationserver.service.entity.Authority;
import com.tecomerce.mic.authorizationserver.service.entity.Role;
import com.tecomerce.mic.authorizationserver.service.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserDocument toDocument(User entity);

    public User toEntity(UserDocument document);

    public List<UserDocument> toDocumentList(List<User> entities);

    public List<User> toEntityList(List<UserDocument> documents);

}
