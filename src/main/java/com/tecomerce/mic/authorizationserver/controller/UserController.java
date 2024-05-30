package com.tecomerce.mic.authorizationserver.controller;

import com.tecomerce.mic.authorizationserver.controller.mapper.UserDetailDtoMapper;
import com.tecomerce.mic.authorizationserver.controller.mapper.UserDtoMapper;
import com.tecomerce.mic.authorizationserver.controller.service.UserApi;
import com.tecomerce.mic.authorizationserver.controller.service.UserDetailApi;
import com.tecomerce.mic.authorizationserver.controller.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.controller.service.dto.UserDTO;
import com.tecomerce.mic.authorizationserver.controller.service.dto.UserDetailDTO;
import com.tecomerce.mic.authorizationserver.service.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/users")
public class UserController implements UserApi , UserDetailApi {

    private final UserUseCase useCase;
    private final UserDtoMapper mapper;
    private final UserDetailDtoMapper uDmapper;

    @Override
    public ResponseEntity<UserDTO> create(UserDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDTO> update(UserDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<UserDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDetailDTO> findByUserName(String userName) {
        return new ResponseEntity<>(uDmapper.toDto(useCase.findByUsername(userName)), HttpStatus.OK);
    }
}
