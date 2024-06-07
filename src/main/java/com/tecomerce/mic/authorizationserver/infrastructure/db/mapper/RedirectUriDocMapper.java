package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.RedirectUriDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RedirectUriDocMapper {

    public RedirectUri toEntity(RedirectUriDocument document);

    public RedirectUriDocument toDocument(RedirectUri entity);

    public List<RedirectUri> toEntityList(List<RedirectUriDocument> documents);

    public List<RedirectUriDocument> toDocumentList(List<RedirectUri> entities);
}
