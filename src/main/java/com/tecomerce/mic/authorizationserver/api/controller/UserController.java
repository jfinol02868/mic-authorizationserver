package com.tecomerce.mic.authorizationserver.api.controller;

import com.tecomerce.mic.authorizationserver.api.mapper.UserDTOMapper;
import com.tecomerce.mic.authorizationserver.api.mapper.UserDetailDtoMapper;
import com.tecomerce.mic.authorizationserver.api.service.UseDetailApi;
import com.tecomerce.mic.authorizationserver.api.service.UserApi;
import com.tecomerce.mic.authorizationserver.api.service.dto.SortEnumDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.UserDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.UserDetailDTO;
import com.tecomerce.mic.authorizationserver.application.usecase.UserDetailUseCase;
import com.tecomerce.mic.authorizationserver.application.usecase.UserUseCase;
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
@RequestMapping("/v1/users")
@Tags(value = {@Tag(name = "User", description = "User API")})
public class UserController implements UserApi, UseDetailApi {

    private final UserDTOMapper mapper;
    private final UserUseCase useCase;
    private final UserDetailUseCase uDUserCase;
    private final UserDetailDtoMapper uDMapper;

    @Override
    public ResponseEntity<UserDTO> create(UserDTO entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toEntity(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<UserDTO>> createAll(List<UserDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDTO> update(UserDTO entity, String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toEntity(entity),id)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<UserDTO>> updateAll(List<UserDTO> entities) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.updateAll(mapper.toEntityList(entities))),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)) ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDTO>> findByIds(List<String> ids) {
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
    public ResponseEntity<List<UserDTO>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDTO>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                 String... sortProperties) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(),
                sortProperties)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDetailDTO> findByUserName(String userName) {
        return new ResponseEntity<>(uDMapper.toDto(uDUserCase.findByUsername(userName.trim())) , HttpStatus.OK);
    }
}
