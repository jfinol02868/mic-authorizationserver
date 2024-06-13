package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ScopeRepositoryAdapter extends JpaRepository<ScopeEntity, String>, JpaSpecificationExecutor<ScopeEntity> {
}
