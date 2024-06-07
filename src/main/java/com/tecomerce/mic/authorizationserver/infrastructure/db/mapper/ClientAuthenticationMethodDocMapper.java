package com.tecomerce.mic.authorizationserver.infrastructure.db.mapper;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientAuthenticationMethodDTO;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientAuthenticationMethodDocMapper {

    public ClientAuthenticationMethod toEntity(ClientAuthenticationMethodDocument document);

    public ClientAuthenticationMethodDocument toDocument(ClientAuthenticationMethod entity);

    public List<ClientAuthenticationMethod> toEntityList(List<ClientAuthenticationMethodDocument> documents);

    public List<ClientAuthenticationMethodDocument> toDocumentList(List<ClientAuthenticationMethod> entities);
}
