package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.UserDetailDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDetailRepositoryAdapter extends MongoRepository<UserDetailDocument, String> {
    public Optional<UserDetailDocument> findByUsername(String username);
}
