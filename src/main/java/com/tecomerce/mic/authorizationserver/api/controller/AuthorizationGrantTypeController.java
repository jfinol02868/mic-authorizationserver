package com.tecomerce.mic.authorizationserver.api.controller;


import com.tecomerce.mic.authorizationserver.api.mapper.AuthorizationGrantTypeDTOMapper;
import com.tecomerce.mic.authorizationserver.api.service.AuthorizationGrantTypeApi;
import com.tecomerce.mic.authorizationserver.api.service.dto.AuthorizationGrantTypeDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.application.usecase.AuthorizationGrantTypeUseCase;
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
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/v1/authorizationGrantType")
@Tags(value = {@Tag(name = "Authorization Grant Type", description = "Authorization Grant Type API")})
public class AuthorizationGrantTypeController implements AuthorizationGrantTypeApi {

    private final AuthorizationGrantTypeUseCase useCase;
    private final AuthorizationGrantTypeDTOMapper mapper;

    @Override
    public ResponseEntity<AuthorizationGrantTypeDTO> create(AuthorizationGrantTypeDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<AuthorizationGrantTypeDTO>> createAll(List<AuthorizationGrantTypeDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthorizationGrantTypeDTO> update(AuthorizationGrantTypeDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<AuthorizationGrantTypeDTO>> updateAll(List<AuthorizationGrantTypeDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.updateAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthorizationGrantTypeDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)) ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AuthorizationGrantTypeDTO>> findByIds(List<String> ids) {
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
    public ResponseEntity<List<AuthorizationGrantTypeDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AuthorizationGrantTypeDTO>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                 String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(),
                sortProperties)), HttpStatus.OK);
    }
}
