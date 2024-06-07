package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RedirectUriRepositoryAdapter extends MongoRepository<RedirectUriDocument, String> {
}
