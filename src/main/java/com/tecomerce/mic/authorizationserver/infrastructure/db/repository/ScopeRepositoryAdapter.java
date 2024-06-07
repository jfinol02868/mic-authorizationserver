package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScopeRepositoryAdapter extends MongoRepository<ScopeDocument, String> {
}
