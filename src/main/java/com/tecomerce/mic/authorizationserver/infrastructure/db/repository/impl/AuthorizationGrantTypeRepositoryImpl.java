package com.tecomerce.mic.authorizationserver.infrastructure.db.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.AuthorizationGrantTypeRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.AuthorizationGrantTypeDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.AuthorizationGrantTypeRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.infrastructure.util.DynamicFilterMap;
import com.tecomerce.mic.authorizationserver.infrastructure.util.IdGenerator;
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
public class AuthorizationGrantTypeRepositoryImpl implements AuthorizationGrantTypeRepository {

    private final MongoTemplate template;
    private final IdGenerator idGenerator;
    private final DynamicFilterMap dynamicFilterMap;
    private final AuthorizationGrantTypeDocMapper mapper;
    private final AuthorizationGrantTypeRepositoryAdapter repository;

    @Override
    public AuthorizationGrantType create(AuthorizationGrantType entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(AuthorizationGrantTypeDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<AuthorizationGrantType> createAll(List<AuthorizationGrantType> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(AuthorizationGrantTypeDocument.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public AuthorizationGrantType update(AuthorizationGrantType entity, String id) {
        AuthorizationGrantType role = (AuthorizationGrantType) this.mapperToUpdate(entity, id);
        return mapper.toEntity(repository.save(mapper.toDocument(role)));
    }

    @Override
    @Transactional
    public List<AuthorizationGrantType> updateAll(List<AuthorizationGrantType> entities) {
        List<AuthorizationGrantType> roles =  entities.stream().map(entity -> {
            return (AuthorizationGrantType) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        AuthorizationGrantType role = this.findById(id);
        ((AuthorizationGrantType)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public AuthorizationGrantType findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
    }

    @Override
    @Transactional
    public List<AuthorizationGrantType> findByIds(List<String> ids) {
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
    public List<AuthorizationGrantType> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<AuthorizationGrantTypeDocument> role = repository.findAll(pageRequest);
        return mapper.toEntityList(role.getContent());
    }

    @Override
    public List<AuthorizationGrantType> filters(AuthorizationGrantType role, int page, int size, String direction, String... sortProperties) {
        Field[] fields = AuthorizationGrantType.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, role, page, size, direction, sortProperties);
        return mapper.toEntityList(template.find(query, AuthorizationGrantTypeDocument.class));
    }
}
