package com.tecomerce.mic.authorizationserver.infrastructure.db.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoryAdapter extends MongoRepository<UserDocument, String> {
}
