package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDocMapper {

    public Client toEntity(ClientDocument document);

    public ClientDocument toDocument(Client entity);

    public List<Client> toEntityList(List<ClientDocument> documents);

    public List<ClientDocument> toDocumentList(List<Client> entities);
}
