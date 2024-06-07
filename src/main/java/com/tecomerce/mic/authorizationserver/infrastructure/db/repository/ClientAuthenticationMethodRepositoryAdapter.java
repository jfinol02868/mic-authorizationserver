package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientAuthenticationMethodRepositoryAdapter extends MongoRepository<ClientAuthenticationMethodDocument, String> {
}
