package com.tecomerce.mic.authorizationserver.controller;

import com.tecomerce.mic.authorizationserver.controller.mapper.AuthorityDtoMapper;
import com.tecomerce.mic.authorizationserver.controller.service.AuthorityApi;
import com.tecomerce.mic.authorizationserver.controller.service.dto.AuthorityDTO;
import com.tecomerce.mic.authorizationserver.controller.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.service.usecase.AuthorityUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/authorities")
public class AuthorityController implements AuthorityApi {

    private final AuthorityUseCase useCase;
    private final AuthorityDtoMapper mapper;

    @Override
    public ResponseEntity<AuthorityDTO> create(AuthorityDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthorityDTO> update(AuthorityDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthorityDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<AuthorityDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>( mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }
}
