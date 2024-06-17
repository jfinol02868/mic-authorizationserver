package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, String> {

    Optional<ClientEntity> findByClientId(String clientId);
}
