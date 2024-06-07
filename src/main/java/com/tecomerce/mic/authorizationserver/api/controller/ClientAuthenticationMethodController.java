package com.tecomerce.mic.authorizationserver.api.controller;

import com.tecomerce.mic.authorizationserver.api.mapper.ClientAuthenticationMethodDTOMapper;
import com.tecomerce.mic.authorizationserver.api.service.ClientAuthenticationMethodApi;
import com.tecomerce.mic.authorizationserver.api.service.dto.ClientAuthenticationMethodDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.application.usecase.ClientAuthenticationMethodUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/clientAuthenticationMethod")
@Tags(value = {@Tag(name = "Client Authentication Method", description = "Client Authentication Method API")})
public class ClientAuthenticationMethodController implements ClientAuthenticationMethodApi {

    private final ClientAuthenticationMethodUseCase useCase;
    private final ClientAuthenticationMethodDTOMapper mapper;

    @Override
    public ResponseEntity<ClientAuthenticationMethodDTO> create(ClientAuthenticationMethodDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientAuthenticationMethodDTO>> createAll(List<ClientAuthenticationMethodDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientAuthenticationMethodDTO> update(ClientAuthenticationMethodDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientAuthenticationMethodDTO>> updateAll(List<ClientAuthenticationMethodDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.updateAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientAuthenticationMethodDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)) ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientAuthenticationMethodDTO>> findByIds(List<String> ids) {
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
    public ResponseEntity<List<ClientAuthenticationMethodDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientAuthenticationMethodDTO>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                                   String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(),
                sortProperties)), HttpStatus.OK);
    }
}
