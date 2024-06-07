package com.tecomerce.mic.authorizationserver.infrastructure.db.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.RedirectUriRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.RedirectUriDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.RedirectUriRepositoryAdapter;
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
public class RedirectUriRepositoryImpl implements RedirectUriRepository {

    private final MongoTemplate template;
    private final IdGenerator idGenerator;
    private final RedirectUriDocMapper mapper;
    private final DynamicFilterMap dynamicFilterMap;
    private final RedirectUriRepositoryAdapter repository;

    @Override
    public RedirectUri create(RedirectUri entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RedirectUriDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<RedirectUri> createAll(List<RedirectUri> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RedirectUriDocument.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public RedirectUri update(RedirectUri entity, String id) {
        RedirectUri role = (RedirectUri) this.mapperToUpdate(entity, id);
        return mapper.toEntity(repository.save(mapper.toDocument(role)));
    }

    @Override
    @Transactional
    public List<RedirectUri> updateAll(List<RedirectUri> entities) {
        List<RedirectUri> roles =  entities.stream().map(entity -> {
            return (RedirectUri) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        RedirectUri role = this.findById(id);
        ((RedirectUri)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public RedirectUri findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
    }

    @Override
    @Transactional
    public List<RedirectUri> findByIds(List<String> ids) {
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
    public List<RedirectUri> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<RedirectUriDocument> role = repository.findAll(pageRequest);
        return mapper.toEntityList(role.getContent());
    }

    @Override
    public List<RedirectUri> filters(RedirectUri role, int page, int size, String direction, String... sortProperties) {
        Field[] fields = RedirectUri.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, role, page, size, direction, sortProperties);
        return mapper.toEntityList(template.find(query, RedirectUriDocument.class));
    }
}
