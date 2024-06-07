package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.RedirectUriUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.domain.repository.RedirectUriRepository;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedirectUriUseCaseImpl implements RedirectUriUseCase {

    private final MapperUtil filters;
    private final RedirectUriRepository repository;

    @Override
    public RedirectUri create(RedirectUri entity) {
        return repository.create(entity);
    }

    @Override
    public List<RedirectUri> createAll(List<RedirectUri> entities) {
        return repository.createAll(entities);
    }

    @Override
    public RedirectUri update(RedirectUri entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<RedirectUri> updateAll(List<RedirectUri> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public RedirectUri findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<RedirectUri> findByIds(List<String> id) {
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
    public List<RedirectUri> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<RedirectUri> filters(String properties, int page, int size, String direction, String... sortProperties) {
        RedirectUri redirectUri = (RedirectUri) filters.mappingEntity(properties, RedirectUri.class);
        return repository.filters(redirectUri, page, size, direction, sortProperties);
    }
}
