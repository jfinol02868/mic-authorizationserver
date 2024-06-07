package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.ClientDetailUseCase;
import com.tecomerce.mic.authorizationserver.application.usecase.ClientUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientDetailRepository;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientRepository;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase, ClientDetailUseCase {

    private final MapperUtil filters;
    private final ClientRepository repository;
    private final ClientDetailRepository cDRepository;

    @Override
    public Client create(Client entity) {
        return repository.create(entity);
    }

    @Override
    public List<Client> createAll(List<Client> entities) {
        return repository.createAll(entities);
    }

    @Override
    public Client update(Client entity, String id) {
        return repository.update(entity, id);
    }

    @Override
    public List<Client> updateAll(List<Client> entities) {
        return repository.updateAll(entities);
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

    @Override
    public ClientDetail getClientDetail(String id) {
        return cDRepository.getClientDetail(id);
    }
}
