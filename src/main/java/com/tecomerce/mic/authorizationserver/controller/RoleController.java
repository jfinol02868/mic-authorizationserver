package com.tecomerce.mic.authorizationserver.controller;

import com.tecomerce.mic.authorizationserver.controller.mapper.RoleDtoMapper;
import com.tecomerce.mic.authorizationserver.controller.service.RoleApi;
import com.tecomerce.mic.authorizationserver.controller.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.controller.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.service.usecase.RoleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/roles")
public class RoleController implements RoleApi {

    private final RoleUseCase useCase;
    private final RoleDtoMapper mapper;

    @Override
    public ResponseEntity<RoleDTO> create(RoleDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RoleDTO> update(RoleDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RoleDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<RoleDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>( mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }
}
