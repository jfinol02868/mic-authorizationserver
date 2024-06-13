package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository;

import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepositoryAdapter extends JpaRepository<RoleEntity, String>, JpaSpecificationExecutor<RoleEntity> {
}
