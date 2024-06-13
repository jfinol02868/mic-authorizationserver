package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.ScopeRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ScopeDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.ScopeEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.ScopeRepositoryAdapter;
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
public class ScopeRepositoryImpl implements ScopeRepository {

    private final ScopeDocMapper mapper;
    private final IdGenerator idGenerator;
    private final ScopeRepositoryAdapter repository;

    @Override
    public Scope create(Scope entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ScopeEntity.class));
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    public List<Scope> createAll(List<Scope> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ScopeEntity.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Scope update(Scope entity, String id) {
        Scope role = (Scope) this.mapperToUpdate(entity, id);
        return mapper.toModel(repository.save(mapper.toEntity(role)));
    }

    @Override
    @Transactional
    public List<Scope> updateAll(List<Scope> entities) {
        List<Scope> roles =  entities.stream().map(entity -> {
            return (Scope) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        Scope role = this.findById(id);
        ((Scope)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public Scope findById(String id) {
        return mapper.toModel(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
    }

    @Override
    @Transactional
    public List<Scope> findByIds(List<String> ids) {
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
    public List<Scope> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ScopeEntity> role = repository.findAll(pageRequest);
        return mapper.toModelList(role.getContent());
    }

    @Override
    public List<Scope> filters(Scope entity, int page, int size, String direction, String... sortProperties) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        Specification<ScopeEntity> spec = new GenericSpecification<>(mapper.toEntity(entity));
        Page<ScopeEntity> result = repository.findAll(spec, pageable);
        return mapper.toModelList(result.getContent());
    }
}
