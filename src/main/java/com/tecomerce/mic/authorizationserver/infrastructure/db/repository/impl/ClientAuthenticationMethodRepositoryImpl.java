package com.tecomerce.mic.authorizationserver.infrastructure.db.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientAuthenticationMethod;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientAuthenticationMethodRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ClientAuthenticationMethodDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.ClientAuthenticationMethodRepositoryAdapter;
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
public class ClientAuthenticationMethodRepositoryImpl implements ClientAuthenticationMethodRepository {


    private final MongoTemplate template;
    private final IdGenerator idGenerator;
    private final DynamicFilterMap dynamicFilterMap;
    private final ClientAuthenticationMethodDocMapper mapper;
    private final ClientAuthenticationMethodRepositoryAdapter repository;

    @Override
    public ClientAuthenticationMethod create(ClientAuthenticationMethod entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientAuthenticationMethodDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<ClientAuthenticationMethod> createAll(List<ClientAuthenticationMethod> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientAuthenticationMethodDocument.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public ClientAuthenticationMethod update(ClientAuthenticationMethod entity, String id) {
        ClientAuthenticationMethod role = (ClientAuthenticationMethod) this.mapperToUpdate(entity, id);
        return mapper.toEntity(repository.save(mapper.toDocument(role)));
    }

    @Override
    @Transactional
    public List<ClientAuthenticationMethod> updateAll(List<ClientAuthenticationMethod> entities) {
        List<ClientAuthenticationMethod> roles =  entities.stream().map(entity -> {
            return (ClientAuthenticationMethod) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        ClientAuthenticationMethod role = this.findById(id);
        ((ClientAuthenticationMethod)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public ClientAuthenticationMethod findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("ClientAuthenticationMethod not found")));
    }

    @Override
    @Transactional
    public List<ClientAuthenticationMethod> findByIds(List<String> ids) {
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
    public List<ClientAuthenticationMethod> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ClientAuthenticationMethodDocument> role = repository.findAll(pageRequest);
        return mapper.toEntityList(role.getContent());
    }

    @Override
    public List<ClientAuthenticationMethod> filters(ClientAuthenticationMethod role, int page, int size, String direction, String... sortProperties) {
        Field[] fields = ClientAuthenticationMethod.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, role, page, size, direction, sortProperties);
        return mapper.toEntityList(template.find(query, ClientAuthenticationMethodDocument.class));
    }
}
