package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.UserDetailDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDetailDocMapper {

    public UserDetail toEntity(UserDetailDocument document);

    public UserDetailDocument toDocument(UserDetail entity);

    public List<UserDetail> toEntityList(List<UserDetailDocument> documents);

    public  List<UserDetailDocument> toDocumentList(List<UserDetail> entities);



}
