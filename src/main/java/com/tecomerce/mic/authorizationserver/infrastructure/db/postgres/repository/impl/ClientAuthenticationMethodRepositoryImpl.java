package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientAuthenticationMethodRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ClientAuthenticationMethodDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ClientAuthenticationMethodEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.ClientAuthenticationMethodRepositoryAdapter;
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
public class ClientAuthenticationMethodRepositoryImpl implements ClientAuthenticationMethodRepository {

    private final IdGenerator idGenerator;
    private final ClientAuthenticationMethodDocMapper mapper;
    private final ClientAuthenticationMethodRepositoryAdapter repository;

    @Override
    public ClientAuthenticationMethod create(ClientAuthenticationMethod entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientAuthenticationMethodEntity.class));
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    public List<ClientAuthenticationMethod> createAll(List<ClientAuthenticationMethod> entities) {
        List<ClientAuthenticationMethod> clientAuthenticationMethods =  entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientAuthenticationMethodEntity.class));
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(clientAuthenticationMethods)));
    }

    @Override
    public ClientAuthenticationMethod update(ClientAuthenticationMethod entity, String id) {
        ClientAuthenticationMethod role = (ClientAuthenticationMethod) this.mapperToUpdate(entity, id);
        return mapper.toModel(repository.save(mapper.toEntity(role)));
    }

    @Override
    @Transactional
    public List<ClientAuthenticationMethod> updateAll(List<ClientAuthenticationMethod> entities) {
        List<ClientAuthenticationMethod> roles =  entities.stream().map(entity -> {
            return (ClientAuthenticationMethod) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        ClientAuthenticationMethod role = this.findById(id);
        ((ClientAuthenticationMethod)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public ClientAuthenticationMethod findById(String id) {
        return mapper.toModel(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
    }

    @Override
    @Transactional
    public List<ClientAuthenticationMethod> findByIds(List<String> ids) {
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
    public List<ClientAuthenticationMethod> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ClientAuthenticationMethodEntity> role = repository.findAll(pageRequest);
        return mapper.toModelList(role.getContent());
    }

    @Override
    public List<ClientAuthenticationMethod> filters(ClientAuthenticationMethod entity, int page, int size, String direction, String... sortProperties) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        Specification<ClientAuthenticationMethodEntity> spec = new GenericSpecification<>(mapper.toEntity(entity));
        Page<ClientAuthenticationMethodEntity> result = repository.findAll(spec, pageRequest);
        return mapper.toModelList(result.getContent());
    }
}
