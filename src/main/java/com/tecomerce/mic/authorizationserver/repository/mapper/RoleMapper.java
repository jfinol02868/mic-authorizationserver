package com.tecomerce.mic.authorizationserver.repository.mapper;

import com.tecomerce.mic.authorizationserver.repository.document.RoleDocument;
import com.tecomerce.mic.authorizationserver.service.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    public RoleDocument toDocument(Role entity);

    public Role toEntity(RoleDocument document);

    public List<RoleDocument> toDocumentList(List<Role> entities);

    public List<Role> toEntityList(List<RoleDocument> documents);

}
