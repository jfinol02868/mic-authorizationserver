package com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.User;
import com.tecomerce.mic.authorizationserver.domain.exception.EntityNotFoundException;
import com.tecomerce.mic.authorizationserver.domain.repository.RoleRepository;
import com.tecomerce.mic.authorizationserver.domain.repository.UserRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.UserDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.entity.UserEntity;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.UserRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.infrastructure.db.postgres.repository.specification.GenericSpecification;
import com.tecomerce.mic.authorizationserver.infrastructure.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserDocMapper mapper;
    private final IdGenerator idGenerator;
    private final RoleRepository rRepository;
    private final UserRepositoryAdapter repository;


    @Override
    public User create(User entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(UserEntity.class));
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    public List<User> createAll(List<User> entities) {
        List<User> users = entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(UserEntity.class));
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(users)));

    }

    @Override
    public User update(User entity, String id) {
        User user = (User) this.mapperToUpdate(entity, id);
        return mapper.toModel(repository.save(mapper.toEntity(user)));
    }

    @Override
    public List<User> updateAll(List<User> entities) {
        List<User> users = entities.stream().map(entity -> {
            return (User) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(users)));
    }

    private Object mapperToUpdate(Object source, String id) {
        User user = this.findById(id);
        ((User) source).setId(user.getId());
        BeanUtils.copyProperties(source, user);
        return user;
    }

    @Override
    public User findById(String id) {
        return mapper.toModel(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id)));
    }

    @Override
    public List<User> findByIds(List<String> ids) {
        return ids.stream().map(this::findById).toList();
    }

    @Override
    public void delete(String id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        ids.forEach(this::findById);
        repository.deleteAllById(ids);
    }

    @Override
    public List<User> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<UserEntity> user = repository.findAll(pageRequest);
        return mapper.toModelList(user.getContent());
    }

    @Override
    public List<User> filters(User entity, int page, int size, String direction, String... sortProperties) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(dir, sortProperties));
        Specification<UserEntity> spec = new GenericSpecification<>(mapper.toEntity(entity));
        Page<UserEntity> result = repository.findAll(spec, pageable);
        return mapper.toModelList(result.getContent());
    }
}
