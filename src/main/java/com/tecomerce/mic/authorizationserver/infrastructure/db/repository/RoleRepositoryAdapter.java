package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RoleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepositoryAdapter extends MongoRepository<RoleDocument, String> {
}
