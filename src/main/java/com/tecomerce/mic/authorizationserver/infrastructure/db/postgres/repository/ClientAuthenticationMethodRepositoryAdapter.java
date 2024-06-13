package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClientAuthenticationMethodRepositoryAdapter extends JpaRepository<ClientAuthenticationMethodEntity, String>, JpaSpecificationExecutor<ClientAuthenticationMethodEntity> {
}
