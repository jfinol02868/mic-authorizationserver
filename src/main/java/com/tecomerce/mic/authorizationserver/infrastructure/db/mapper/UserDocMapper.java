package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.User;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.UserDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDocMapper {

    public User toEntity(UserDocument document);

    public UserDocument toDocument(User entity);

    public List<User> toEntityList(List<UserDocument> documents);

    public  List<UserDocument> toDocumentList(List<User> entities);
}
