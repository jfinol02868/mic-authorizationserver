package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorizationGrantTypeRepositoryAdapter extends MongoRepository<AuthorizationGrantTypeDocument, String> {
}
