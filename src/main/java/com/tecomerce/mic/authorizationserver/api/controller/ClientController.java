package com.tecomerce.mic.authorizationserver.api.controller;

import com.tecomerce.mic.authorizationserver.api.mapper.ClientDTOMapper;
import com.tecomerce.mic.authorizationserver.api.mapper.ClientDetailDTOMapper;
import com.tecomerce.mic.authorizationserver.api.service.ClientApi;
import com.tecomerce.mic.authorizationserver.api.service.ClientDetailApi;
import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDetailDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.application.usecase.ClientDetailUseCase;
import com.tecomerce.mic.authorizationserver.application.usecase.ClientUseCase;
import com.tecomerce.mic.authorizationserver.infrastructure.db.mapper.ClientDetailDocMapper;
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
@RequestMapping("/v1/client")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Tags(value = {@Tag(name = "Client", description = "Client API")})
public class ClientController implements ClientApi, ClientDetailApi {

    private final ClientUseCase useCase;
    private final ClientDTOMapper mapper;
    private final ClientDetailUseCase cDUseCase;
    private final ClientDetailDTOMapper cDMapper;

    @Override
    public ResponseEntity<ClientDTO> create(ClientDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> createAll(List<ClientDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientDTO> update(ClientDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> updateAll(List<ClientDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.updateAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClientDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)) ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> findByIds(List<String> ids) {
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
    public ResponseEntity<List<ClientDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                                   String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(),
                sortProperties)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDetailDTO> findClientDetailById(String id) {
        return new ResponseEntity<>(cDMapper.toDto(cDUseCase.getClientDetail(id)), HttpStatus.OK);
    }
}
