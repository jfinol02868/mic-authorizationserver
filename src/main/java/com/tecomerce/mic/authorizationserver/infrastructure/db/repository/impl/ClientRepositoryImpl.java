package com.tecomerce.mic.authorizationserver.infrastructure.db.repository.impl;

import com.tecomerce.mic.authorizationserver.domain.entity.Client;
import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientDetailRepository;
import com.tecomerce.mic.authorizationserver.domain.repository.ClientRepository;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDetailDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ClientDetailDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ClientDocMapper;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.ClientDetailRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.infrastructure.db.repository.ClientRepositoryAdapter;
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
public class ClientRepositoryImpl implements ClientRepository, ClientDetailRepository {

    private final MongoTemplate template;
    private final ClientDocMapper mapper;
    private final IdGenerator idGenerator;
    private final ClientDetailDocMapper cDMapper;
    private final DynamicFilterMap dynamicFilterMap;
    private final ClientRepositoryAdapter repository;
    private final ClientDetailRepositoryAdapter cDRepository;


    @Override
    public Client create(Client entity) {
        if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientDocument.class));
        return mapper.toEntity(repository.save(mapper.toDocument(entity)));
    }

    @Override
    public List<Client> createAll(List<Client> entities) {
        return entities.stream().peek(entity -> {
            if (Objects.isNull(entity.getId())) entity.setId(idGenerator.generateId(ClientDocument.class));
        }).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Client update(Client entity, String id) {
        Client role = (Client) this.mapperToUpdate(entity, id);
        return mapper.toEntity(repository.save(mapper.toDocument(role)));
    }

    @Override
    @Transactional
    public List<Client> updateAll(List<Client> entities) {
        List<Client> roles =  entities.stream().map(entity -> {
            return (Client) this.mapperToUpdate(entity, entity.getId());
        }).toList();
        return mapper.toEntityList(repository.saveAll(mapper.toDocumentList(roles)));
    }

    private Object mapperToUpdate(Object source, String id) {
        Client role = this.findById(id);
        ((Client)source).setId(role.getId());
        BeanUtils.copyProperties(source, role);
        return role;
    }

    @Override
    @Transactional
    public Client findById(String id) {
        return mapper.toEntity(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found")));
    }

    @Override
    @Transactional
    public List<Client> findByIds(List<String> ids) {
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
    public List<Client> findAllPaginated(int page, int size, String sort, String direction) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(dir, sort));
        Page<ClientDocument> role = repository.findAll(pageRequest);
        return mapper.toEntityList(role.getContent());
    }

    @Override
    public List<Client> filters(Client role, int page, int size, String direction, String... sortProperties) {
        Field[] fields = Client.class.getDeclaredFields();
        Query query = dynamicFilterMap.queryFilter(fields, role, page, size, direction, sortProperties);
        return mapper.toEntityList(template.find(query, ClientDocument.class));
    }

    @Override
    public ClientDetail getClientDetail(String id) {
        ClientDetailDocument clientDetailDocument = cDRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return cDMapper.toEntity(clientDetailDocument);
    }
}
