package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.AuthorizationGrantTypeUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.domain.repository.AuthorizationGrantTypeRepository;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorizationGrantTypeUseCaseImpl implements AuthorizationGrantTypeUseCase {

    private final MapperUtil filters;
    private final AuthorizationGrantTypeRepository repository;

    @Override
    public AuthorizationGrantType create(AuthorizationGrantType entity) {
        return repository.create(entity);
    }

    @Override
    public List<AuthorizationGrantType> createAll(List<AuthorizationGrantType> entities) {
        return repository.createAll(entities);
    }

    @Override
    public AuthorizationGrantType update(AuthorizationGrantType entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<AuthorizationGrantType> updateAll(List<AuthorizationGrantType> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public AuthorizationGrantType findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<AuthorizationGrantType> findByIds(List<String> id) {
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
    public List<AuthorizationGrantType> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<AuthorizationGrantType> filters(String properties, int page, int size, String direction, String... sortProperties) {
        AuthorizationGrantType authorizationGrantType = (AuthorizationGrantType) filters.mappingEntity(properties, AuthorizationGrantType.class);
        return repository.filters(authorizationGrantType, page, size, direction, sortProperties);
    }
}
