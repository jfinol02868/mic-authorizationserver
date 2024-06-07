package com.tecomerce.mic.authorizationserver.infrastructure.db.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.User;
import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;
import com.tecomerce.mic.authorizationserver.domain.repository.RoleRepository;
import com.tecomerce.mic.authorizationserver.domain.repository.UserDetailRepository;
import com.tecomerce.mic.authorizationserver.domain.repository.UserRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.UserDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.UserDetailDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.UserDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.UserDetailRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.UserRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.infrastructure.util.DynamicFilterMap;
import com.tecomerce.mic.authorizationserver.infrastructure.util.IdGenerator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository, UserDetailRepository {

    private final UserDocMapper mapper;
    private final MongoTemplate template;
    private final IdGenerator idGenerator;
    private final RoleRepository rRepository;
    private final UserDetailDocMapper uDMapper;
    private final UserRepositoryAdapter repository;
    private final DynamicFilterMap dynamicFilterMap;
    private final UserDetailRepositoryAdapter uDRepository;


    @Override
    public User create(User entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(UserDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<User> createAll(List<User> entities) {
        List<User> users = entities.stream().peek(entity -> {
            rRepository.findByIds(entity.getRoles());
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(UserDocument.class));
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(users)));
    }

    @Override
    public User update(User entity, String id) {
        User user = (User)this.mapperToUpdate(entity, id);
        return mapper.toEntity(repository.save(mapper.toDocument(user)));
    }

    @Override
    public List<User> updateAll(List<User> entities) {
        List<User> users =  entities.stream().map(entity -> {
            return (User) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(users)));
    }

    private Object mapperToUpdate(Object source, String id) {
        User user = this.findById(id);
        ((User)source).setId(user.getId());
        BeanUtils.copyProperties(source, user);
        return user;
    }

    @Override
    public User findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role not found")));
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
        Page<UserDocument> user = repository.findAll(pageRequest);
        return mapper.toEntityList(user.getContent());
    }

    @Override
    public List<User> filters(User entity, int page, int size, String direction, String... sortProperties) {
        Field[] fields = User.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, entity, page, size, direction, sortProperties);
        return mapper.toEntityList(template.find(query, UserDocument.class));
    }

    @Override
    public UserDetail findByUsername(String username) {

        return uDMapper.toEntity(uDRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("User not found")));
    }
}
