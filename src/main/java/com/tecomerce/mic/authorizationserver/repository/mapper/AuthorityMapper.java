package com.tecomerce.mic.authorizationserver.repository.mapper;

import com.tecomerce.mic.authorizationserver.repository.document.AuthorityDocument;
import com.tecomerce.mic.authorizationserver.repository.document.RoleDocument;
import com.tecomerce.mic.authorizationserver.service.entity.Authority;
import com.tecomerce.mic.authorizationserver.service.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {

    public AuthorityDocument toDocument(Authority entity);

    public Authority toEntity(AuthorityDocument document);

    public List<AuthorityDocument> toDocumentList(List<Authority> entities);

    public List<Authority> toEntityList(List<AuthorityDocument> documents);

}
