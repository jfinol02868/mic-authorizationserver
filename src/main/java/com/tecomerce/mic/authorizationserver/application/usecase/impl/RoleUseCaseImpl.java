package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.RoleUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.repository.RoleRepository;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleUseCaseImpl implements RoleUseCase  {

    private final MapperUtil filters;
    private final RoleRepository repository;

    @Override
    public Role create(Role entity) {
        return repository.create(entity);
    }

    @Override
    public List<Role> createAll(List<Role> entities) {
        return repository.createAll(entities);
    }

    @Override
    public Role update(Role entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Role> updateAll(List<Role> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Role findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Role> findByIds(List<String> id) {
        return repository.findByIds(id);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        repository.deleteAll(ids);
    }

    @Override
    public List<Role> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Role> filters(String properties, int page, int size, String direction, String... sortProperties) {
        Role role = (Role) filters.mappingEntity(properties, Role.class);
        return repository.filters(role, page, size, direction, sortProperties);
    }
}
