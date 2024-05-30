package com.tecomerce.mic.authorizationserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredClientRepositoryAdapter extends MongoRepository<RegisteredClient, String> {

    public RegisteredClient findByClientId(String clientId);
}
