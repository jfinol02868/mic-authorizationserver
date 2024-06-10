package com.tecomerce.mic.authorizationserver.api.controller;

import com.tecomerce.mic.authorizationserver.api.mapper.ScopeDTOMapper;
import com.tecomerce.mic.authorizationserver.api.service.ScopeApi;
import com.tecomerce.mic.authorizationserver.api.service.dto.ScopeDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.application.usecase.ScopeUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/scopes")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Tags(value = {@Tag(name = "Scopes Uri", description = "Scopes API")})
public class ScopeController implements ScopeApi {

    private final ScopeUseCase useCase;
    private final ScopeDTOMapper mapper;

    @Override
    public ResponseEntity<ScopeDTO> create(ScopeDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ScopeDTO>> createAll(List<ScopeDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ScopeDTO> update(ScopeDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ScopeDTO>> updateAll(List<ScopeDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.updateAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ScopeDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)) ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ScopeDTO>> findByIds(List<String> ids) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findByIds(ids)) ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        useCase.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<ScopeDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ScopeDTO>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                        String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(),
                sortProperties)), HttpStatus.OK);
    }
}
