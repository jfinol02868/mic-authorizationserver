package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ClientRepositoryAdapter extends JpaRepository<ClientEntity, String>, JpaSpecificationExecutor<ClientEntity> {

    Optional<ClientEntity> findByClientId(String clientId);
}
