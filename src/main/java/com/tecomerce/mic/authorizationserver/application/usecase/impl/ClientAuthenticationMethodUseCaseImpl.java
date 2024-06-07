package com.tecomerce.mic.authorizationserver.application.usecase.impl;


import com.tecomerce.mic.authorizationserver.application.usecase.ClientAuthenticationMethodUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientAuthenticationMethodRepository;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientAuthenticationMethodUseCaseImpl implements ClientAuthenticationMethodUseCase {

    private final MapperUtil filters;
    private final ClientAuthenticationMethodRepository repository;

    @Override
    public ClientAuthenticationMethod create(ClientAuthenticationMethod entity) {
        return repository.create(entity);
    }

    @Override
    public List<ClientAuthenticationMethod> createAll(List<ClientAuthenticationMethod> entities) {
        return repository.createAll(entities);
    }

    @Override
    public ClientAuthenticationMethod update(ClientAuthenticationMethod entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<ClientAuthenticationMethod> updateAll(List<ClientAuthenticationMethod> entities) {
        return repository.updateAll(entities);
    }

    @Override
    public ClientAuthenticationMethod findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ClientAuthenticationMethod> findByIds(List<String> id) {
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
    public List<ClientAuthenticationMethod> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<ClientAuthenticationMethod> filters(String properties, int page, int size, String direction, String... sortProperties) {
        ClientAuthenticationMethod clientAuthenticationMethod = (ClientAuthenticationMethod) filters.mappingEntity(properties, ClientAuthenticationMethod.class);
        return repository.filters(clientAuthenticationMethod, page, size, direction, sortProperties);
    }
}
