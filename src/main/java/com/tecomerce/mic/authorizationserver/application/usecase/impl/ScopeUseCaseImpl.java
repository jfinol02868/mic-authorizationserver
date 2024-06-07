package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.ScopeUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.domain.repository.ScopeRepository;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScopeUseCaseImpl implements ScopeUseCase {

    private final MapperUtil filters;
    private final ScopeRepository repository;

    @Override
    public Scope create(Scope entity) {
        return repository.create(entity);
    }

    @Override
    public List<Scope> createAll(List<Scope> entities) {
        return repository.createAll(entities);
    }

    @Override
    public Scope update(Scope entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Scope> updateAll(List<Scope> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public Scope findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Scope> findByIds(List<String> id) {
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
    public List<Scope> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Scope> filters(String properties, int page, int size, String direction, String... sortProperties) {
        Scope scope = (Scope) filters.mappingEntity(properties, Scope.class);
        return repository.filters(scope, page, size, direction, sortProperties);
    }
}
