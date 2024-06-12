package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.UserUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import com.tecomerce.mic.authorizationserver.domain.entity.User;
import com.tecomerce.mic.authorizationserver.domain.repository.RoleRepository;
import com.tecomerce.mic.authorizationserver.domain.repository.UserRepository;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserUseCaseImpl implements UserUseCase {

    private final MapperUtil filters;
    private final UserRepository repository;
    private final RoleRepository roleRepository;


    @Override
    public User create(User entity) {
        entity.trimPassword();
        List<Role> roles = new ArrayList<>();
        entity.getRoles().forEach(r -> {
            Role role = roleRepository.findById(r.getId());
            roles.add(role);
        });
        entity.setRoles(roles);
        return repository.create(entity);
    }

    @Override
    public List<User> createAll(List<User> entities) {
        entities.forEach(e -> {
            e.trimPassword();
            e.setRoles(e.getRoles().stream()
                    .map(r -> roleRepository.findById(r.getId()))
                    .collect(Collectors.toList()));
        });
        return repository.createAll(entities);
    }

    @Override
    public User update(User entity, String id) {
        entity.trimPassword();
        entity.setPassword(entity.getPassword());
        return repository.update(entity, id);
    }

    @Override
    public List<User> updateAll(List<User> entities) {
        entities.forEach(e -> {
            e.trimPassword();
            e.setPassword(e.getPassword());
        });
        return repository.updateAll(entities);
    }

    @Override
    public User findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findByIds(List<String> id) {
        return repository.findByIds(id);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        repository.deleteAll(ids);
    }

    @Override
    public List<User> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<User> filters(String properties, int page, int size, String direction, String... sortProperties) {
        User user = (User) filters.mappingEntity(properties, User.class);
        return repository.filters(user, page, size, direction, sortProperties);
    }
}
