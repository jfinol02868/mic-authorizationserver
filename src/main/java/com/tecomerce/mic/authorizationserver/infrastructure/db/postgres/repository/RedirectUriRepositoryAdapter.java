package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RedirectUriEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RedirectUriRepositoryAdapter extends JpaRepository<RedirectUriEntity, String>, JpaSpecificationExecutor<RedirectUriEntity> {
}
