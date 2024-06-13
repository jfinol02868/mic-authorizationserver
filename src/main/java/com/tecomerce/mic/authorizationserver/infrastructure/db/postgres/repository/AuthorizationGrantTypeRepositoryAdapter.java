package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.AuthorizationGrantTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorizationGrantTypeRepositoryAdapter extends JpaRepository<AuthorizationGrantTypeEntity, String>, JpaSpecificationExecutor<AuthorizationGrantTypeEntity> {

}
