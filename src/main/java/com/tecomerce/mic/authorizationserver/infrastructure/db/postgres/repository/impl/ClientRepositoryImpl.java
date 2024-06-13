package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ClientDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.ClientRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.specification.GenericSpecification;
import com.tecomerce.mic.authorizationserver.infrastructure.util.IdGenerator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientDocMapper mapper;
    private final IdGenerator idGenerator;
    private final ClientRepositoryAdapter repository;


    @Override
    public Client create(Client entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientEntity.class));
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    public List<Client> createAll(List<Client> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientEntity.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Client update(Client entity, String id) {
        Client role = (Client) this.mapperToUpdate(entity, id);
        return mapper.toModel(repository.save(mapper.toEntity(role)));
    }

    @Override
    @Transactional
    public List<Client> updateAll(List<Client> entities) {
        List<Client> roles =  entities.stream().map(entity -> {
            return (Client) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        Client role = this.findById(id);
        ((Client)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public Client findById(String id) {
        return mapper.toModel(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
    }

    @Override
    @Transactional
    public List<Client> findByIds(List<String> ids) {
        return ids.stream().map(this::findById).toList();
    }

    @Override
    public void delete(String id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll(List<String> ids) {
        ids.forEach(this::findById);
        repository.deleteAllById(ids);
    }

    @Override
    public List<Client> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ClientEntity> role = repository.findAll(pageRequest);
        return mapper.toModelList(role.getContent());
    }

    @Override
    public List<Client> filters(Client entity, int page, int size, String direction, String... sortProperties) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        Specification<ClientEntity> spec = new GenericSpecification<>(mapper.toEntity(entity));
        Page<ClientEntity> result = repository.findAll(spec, pageable);
        return mapper.toModelList(result.getContent());
    }
}
