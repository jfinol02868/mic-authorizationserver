package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDetailDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDetailDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDetailDocMapper {

    public ClientDetail toEntity(ClientDetailDocument document);

    public ClientDetailDocument toDocument(ClientDetail entity);

    public List<ClientDetail> toEntityList(List<ClientDetailDocument> documents);

    public List<ClientDetailDocument> toDocumentList(List<ClientDetail> entities);
}
