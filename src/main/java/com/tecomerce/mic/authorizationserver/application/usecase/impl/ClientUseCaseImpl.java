package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.ClientUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.domain.repository.*;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    private final MapperUtil filters;
    private final ClientRepository repository;
    private final ScopeRepository sRepository;
    private final RedirectUriRepository rURepository;
    private final AuthorizationGrantTypeRepository aGTRepository;
    private final ClientAuthenticationMethodRepository cAMRepository;

    @Override
    @Transactional
    public Client create(Client entity) {
       this.validateClient(entity);
        return repository.create(entity);
    }

    @Override
    @Transactional
    public List<Client> createAll(List<Client> entities) {
        List<Client> entitiesValidated = entities
                .stream()
                .peek(this::validateClient)
                .collect(Collectors.toList());
        return repository.createAll(entitiesValidated);
    }

    @Override
    @Transactional
    public Client update(Client entity, String id) {
        Client client = repository.findById(id);
        this.validateClient(client);
        return repository.update(entity, id);
    }

    @Override
    @Transactional
    public List<Client> updateAll(List<Client> entities) {
        List<Client> entitiesValidated = entities
                .stream()
                .peek(entity -> {
                    Client client = repository.findById(entity.getId());
                    this.validateClient(client);
        }).collect(Collectors.toList());
        return repository.updateAll(entitiesValidated);
    }

    private final void validateClient(Client entity) {
        entity.getAuthenticationMethods().forEach(cAMRepository::findById);
        entity.getAuthorizationGrantTypes().forEach(aGTRepository::findById);
        entity.getRedirectUris().forEach(rURepository::findById);
        entity.getScopes().forEach(sRepository::findById);
    }

    @Override
    public Client findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> findByIds(List<String> id) {
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
    public List<Client> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Client> filters(String properties, int page, int size, String direction, String... sortProperties) {
        Client client = (Client) filters.mappingEntity(properties, Client.class);
        return repository.filters(client, page, size, direction, sortProperties);
    }
}
