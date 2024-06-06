package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RoleDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleDocMapper {

    public Role toEntity(RoleDocument document);

    public RoleDocument toDocument(Role entity);

    public List<Role> toEntityList(List<RoleDocument> documents);

    public  List<RoleDocument> toDocumentList(List<Role> entities);
}
