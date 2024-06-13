package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.RoleRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.RoleDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.RoleEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.RoleRepositoryAdapter;
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
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleDocMapper mapper;
    private final IdGenerator idGenerator;
    private final RoleRepositoryAdapter repository;


    @Override
    public Role create(Role entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RoleEntity.class));
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    public List<Role> createAll(List<Role> entities) {
       return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(RoleEntity.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Role update(Role entity, String id) {
        Role role = (Role) this.mapperToUpdate(entity, id);
        return mapper.toModel(repository.save(mapper.toEntity(role)));
    }

    @Override
    @Transactional
    public List<Role> updateAll(List<Role> entities) {
        List<Role> roles =  entities.stream().map(entity -> {
            return (Role) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(roles)));
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
        return mapper.toModel(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id)));
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
        Page<RoleEntity> role = repository.findAll(pageRequest);
        return mapper.toModelList(role.getContent());
    }

    @Override
    public List<Role> filters(Role role, int page, int size, String direction, String... sortProperties) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        Specification<RoleEntity> spec = new GenericSpecification<>(mapper.toEntity(role));
        Page<RoleEntity> result = repository.findAll(spec, pageable);
        return mapper.toModelList(result.getContent());
    }
}