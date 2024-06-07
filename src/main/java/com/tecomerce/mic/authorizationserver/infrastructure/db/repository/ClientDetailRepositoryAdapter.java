package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDetailDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientDetailRepositoryAdapter extends MongoRepository<ClientDetailDocument, String> {
}
