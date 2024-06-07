package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ScopeDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScopeDocMapper {

    public Scope toEntity(ScopeDocument dto);

    public ScopeDocument toDocument(Scope entity);

    public List<Scope> toEntityList(List<ScopeDocument> dtos);

    public List<ScopeDocument> toDocumentList(List<Scope> entities);
}
