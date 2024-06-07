package com.tecomerce.mic.authorizationserver.infrastructure.db.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.Scope;
import com.tecomerce.mic.authorizationserver.domain.repository.ScopeRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ScopeDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.ScopeRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.infrastructure.util.DynamicFilterMap;
import com.tecomerce.mic.authorizationserver.infrastructure.util.IdGenerator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class ScopeRepositoryImpl implements ScopeRepository {

    private final ScopeDocMapper mapper;
    private final MongoTemplate template;
    private final IdGenerator idGenerator;
    private final DynamicFilterMap dynamicFilterMap;
    private final ScopeRepositoryAdapter repository;

    @Override
    public Scope create(Scope entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ScopeDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Scope> createAll(List<Scope> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ScopeDocument.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Scope update(Scope entity, String id) {
        Scope role = (Scope) this.mapperToUpdate(entity, id);
        return mapper.toEntity(repository.save(mapper.toDocument(role)));
    }

    @Override
    @Transactional
    public List<Scope> updateAll(List<Scope> entities) {
        List<Scope> roles =  entities.stream().map(entity -> {
            return (Scope) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(roles)));
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
        return mapper.toEntity(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Scope not found")));
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
        Page<ScopeDocument> role = repository.findAll(pageRequest);
        return mapper.toEntityList(role.getContent());
    }

    @Override
    public List<Scope> filters(Scope role, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Scope.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, role, page, size, direction, sortProperties);
        return mapper.toEntityList(template.find(query, ScopeDocument.class));
    }
}
