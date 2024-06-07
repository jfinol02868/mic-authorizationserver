package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorizationGrantTypeDocMapper {

    public AuthorizationGrantType toEntity(AuthorizationGrantTypeDocument document);

    public AuthorizationGrantTypeDocument toDocument(AuthorizationGrantType entity);

    public List<AuthorizationGrantType> toEntityList(List<AuthorizationGrantTypeDocument> documents);

    public List<AuthorizationGrantTypeDocument> toDocumentList(List<AuthorizationGrantType> entities);
}
