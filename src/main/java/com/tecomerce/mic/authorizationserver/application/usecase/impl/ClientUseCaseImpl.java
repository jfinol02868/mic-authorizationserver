package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.application.usecase.ClientUseCase;
import com.tecomerce.mic.authorizationserver.domain.entity.*;
import com.tecomerce.mic.authorizationserver.domain.repository.*;
import com.tecomerce.mic.authorizationserver.domain.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    private final MapperUtil filters;
    private final ClientRepository repository;
    private final ScopeRepository sRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedirectUriRepository rURepository;
    private final AuthorizationGrantTypeRepository aGTRepository;
    private final ClientAuthenticationMethodRepository cAMRepository;

    @Override
    @Transactional
    public Client create(Client entity) {

        List<Scope> scopes = sRepository.findByIds(entity.getScopes()
                .stream().map(Scope::getId).collect(Collectors.toList()));

        List<RedirectUri> redirectUris = rURepository.findByIds(entity.getRedirectUris()
                .stream().map(RedirectUri::getId).collect(Collectors.toList()));

        List<ClientAuthenticationMethod> authenticationMethods = cAMRepository.findByIds(entity.getAuthenticationMethods()
                .stream().map(ClientAuthenticationMethod::getId).collect(Collectors.toList()));

        List<AuthorizationGrantType> authorizationGrantTypes = aGTRepository.findByIds(entity.getAuthorizationGrantTypes()
                .stream().map(AuthorizationGrantType::getId).collect(Collectors.toList()));

        entity.setScopes(scopes);
        entity.setRedirectUris(redirectUris);
        entity.setClientSecret(passwordEncoder.encode(entity.getClientSecret()));
        entity.setAuthenticationMethods(authenticationMethods);
        entity.setAuthorizationGrantTypes(authorizationGrantTypes);
        return repository.create(entity);
    }

    @Override
    @Transactional
    public List<Client> createAll(List<Client> entities) {
        return repository.createAll(entities);
    }

    @Override
    @Transactional
    public Client update(Client entity, String id) {
        Client client = repository.findById(id);
        //this.validateClient(client);
        return repository.update(entity, id);
    }

    @Override
    @Transactional
    public List<Client> updateAll(List<Client> entities) {
        List<Client> entitiesValidated = entities
                .stream()
                .peek(entity -> {
                    Client client = repository.findById(entity.getId());
        }).collect(Collectors.toList());
        return repository.updateAll(entitiesValidated);
    }

    @Override
    public Client findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> findByIds(List<String> id) {
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
    public List<Client> findAllPaginated(int page, int size, String sort, String direction) {
        return repository.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Client> filters(String properties, int page, int size, String direction, String... sortProperties) {
        Client client = (Client) filters.mappingEntity(properties, Client.class);
        return repository.filters(client, page, size, direction, sortProperties);
    }
}
