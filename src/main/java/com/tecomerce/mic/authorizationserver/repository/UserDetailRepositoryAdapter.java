package com.tecomerce.mic.authorizationserver.repository;

import com.tecomerce.mic.authorizationserver.repository.document.UserDetailDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailRepositoryAdapter extends MongoRepository<UserDetailDocument, String> {

    public UserDetailDocument findByUsername(String username);
}
