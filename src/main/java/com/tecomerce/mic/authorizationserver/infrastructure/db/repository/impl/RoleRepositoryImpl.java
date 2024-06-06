package com.tecomerce.mic.authorizationserver.infrastructure.db.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.repository.RoleRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RoleDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.RoleDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.RoleRepositoryAdapter;
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
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleDocMapper mapper;
    private final MongoTemplate template;
    private final IdGenerator idGenerator;
    private final RoleRepositoryAdapter repository;
    private final DynamicFilterMap dynamicFilterMap;


    @Override
    public Role create(Role entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RoleDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Role> createAll(List<Role> entities) {
       return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RoleDocument.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Role update(Role entity, String id) {
        Role role = (Role) this.mapperToUpdate(entity, id);
        return mapper.toEntity(repository.save(mapper.toDocument(role)));
    }

    @Override
    @Transactional
    public List<Role> updateAll(List<Role> entities) {
        List<Role> roles =  entities.stream().map(entity -> {
            return (Role) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        Role role = this.findById(id);
        ((Role)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public Role findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role not found")));
    }

    @Override
    @Transactional
    public List<Role> findByIds(List<String> ids) {
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
    public List<Role> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<RoleDocument> role = repository.findAll(pageRequest);
        return mapper.toEntityList(role.getContent());
    }

    @Override
    public List<Role> filters(Role role, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Role.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, role, page, size, direction, sortProperties);
        return mapper.toEntityList(template.find(query, RoleDocument.class));
    }
}