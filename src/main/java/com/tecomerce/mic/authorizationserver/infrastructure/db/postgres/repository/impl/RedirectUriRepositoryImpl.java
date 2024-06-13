package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.RedirectUri;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.RedirectUriRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.RedirectUriDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RedirectUriEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.RedirectUriRepositoryAdapter;
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
public class RedirectUriRepositoryImpl implements RedirectUriRepository {

    private final IdGenerator idGenerator;
    private final RedirectUriDocMapper mapper;
    private final RedirectUriRepositoryAdapter repository;

    @Override
    public RedirectUri create(RedirectUri entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RedirectUriEntity.class));
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    public List<RedirectUri> createAll(List<RedirectUri> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RedirectUriEntity.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public RedirectUri update(RedirectUri entity, String id) {
        RedirectUri role = (RedirectUri) this.mapperToUpdate(entity, id);
        return mapper.toModel(repository.save(mapper.toEntity(role)));
    }

    @Override
    @Transactional
    public List<RedirectUri> updateAll(List<RedirectUri> entities) {
        List<RedirectUri> roles = entities.stream().map(entity -> {
            return (RedirectUri) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        RedirectUri role = this.findById(id);
        ((RedirectUri) source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public RedirectUri findById(String id) {
        return mapper.toModel(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
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
        Page<RedirectUriEntity> role = repository.findAll(pageRequest);
        return mapper.toModelList(role.getContent());
    }

    @Override
    public List<RedirectUri> filters(RedirectUri entity, int page, int size, String direction, String... sortProperties) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        Specification<RedirectUriEntity> spec = new GenericSpecification<>(mapper.toEntity(entity));
        Page<RedirectUriEntity> result = repository.findAll(spec, pageable);
        return mapper.toModelList(result.getContent());
    }
}
