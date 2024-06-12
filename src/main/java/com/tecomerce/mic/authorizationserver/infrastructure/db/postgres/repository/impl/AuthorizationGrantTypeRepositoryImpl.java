package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.AuthorizationGrantType;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.AuthorizationGrantTypeRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.AuthorizationGrantTypeDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.AuthorizationGrantTypeEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.AuthorizationGrantTypeRepositoryAdapter;
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
public class AuthorizationGrantTypeRepositoryImpl implements AuthorizationGrantTypeRepository {

    private final IdGenerator idGenerator;
    private final AuthorizationGrantTypeDocMapper mapper;
    private final AuthorizationGrantTypeRepositoryAdapter repository;

    @Override
    public AuthorizationGrantType create(AuthorizationGrantType entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(AuthorizationGrantTypeEntity.class));
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    public List<AuthorizationGrantType> createAll(List<AuthorizationGrantType> entities) {
        List<AuthorizationGrantType> authorizationGrantTypes = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(AuthorizationGrantTypeEntity.class));
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(authorizationGrantTypes)));
    }

    @Override
    public AuthorizationGrantType update(AuthorizationGrantType entity, String id) {
        AuthorizationGrantType role = (AuthorizationGrantType) this.mapperToUpdate(entity, id);
        return mapper.toModel(repository.save(mapper.toEntity(role)));
    }

    @Override
    @Transactional
    public List<AuthorizationGrantType> updateAll(List<AuthorizationGrantType> entities) {
        List<AuthorizationGrantType> roles =  entities.stream().map(entity -> {
            return (AuthorizationGrantType) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(roles)));
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
        return mapper.toModel(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
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
        Page<AuthorizationGrantTypeEntity> role = repository.findAll(pageRequest);
        return mapper.toModelList(role.getContent());
    }

    @Override
    public List<AuthorizationGrantType> filters(AuthorizationGrantType authorizationGrantType, int page, int size, String direction, String... sortProperties) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        Specification<AuthorizationGrantTypeEntity> spec = new GenericSpecification<>(mapper.toEntity(authorizationGrantType));
        Page<AuthorizationGrantTypeEntity> result = repository.findAll(spec, pageable);
        return mapper.toModelList(result.getContent());
    }
}
