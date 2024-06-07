package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepositoryAdapter extends MongoRepository<ClientDocument, String> {
}
