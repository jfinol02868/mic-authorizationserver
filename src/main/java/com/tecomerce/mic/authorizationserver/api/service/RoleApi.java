package com.tecomerce.mic.authorizationserver.api.service;

import com.tecomerce.mic.authorizationserver.api.service.dto.MessageResponseDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.RoleDTO;
import com.tecomerce.mic.authorizationserver.api.service.dto.SortEnumDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RoleApi {

    static final String MEDIA_TYPE = "application/json";

    @PostMapping
    @Operation( operationId = "creation-role", description = "Creation of role.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = RoleDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO entity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/massCreation")
    @Operation( operationId = "create-all-role", description = "Create all roles.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = RoleDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default  ResponseEntity<List<RoleDTO>> createAll(@Valid @RequestBody List<RoleDTO> entities) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation( operationId = "update-role", description = "Update role.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = RoleDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<RoleDTO> update(@Valid @RequestBody RoleDTO entity, @PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/massUpdate")
    @Operation( operationId = "update-all-roles", description = "Update all roles.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = RoleDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<RoleDTO>> updateAll(@Valid @RequestBody List<RoleDTO> entities){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    @Operation( operationId = "get-role-by-id", description = "Get role by id.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = RoleDTO.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<RoleDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/getByIds")
    @Operation( operationId = "get-roles-by-ids", description = "Get roles by ids.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = RoleDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<RoleDTO>> findByIds(@RequestParam List<String> ids) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    @Operation( operationId = "delete-role", description = "Delete role by id.")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/deleteByIds")
    @Operation( operationId = "delete-all-roles", description = "Delete roles by ids.")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<Void> deleteAll(@RequestParam List<String> ids) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/paginated")
    @Operation( operationId = "get-roles-paginated", description = "Get roles paginated.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = RoleDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<RoleDTO>> findAllPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(name = "name", defaultValue = "name") String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @GetMapping("/rolesFilter")
    @Operation( operationId = "get-roles-filter", description = "Get roles by filter.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = RoleDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<RoleDTO>> filters(
            @RequestParam(required = false, defaultValue = "{\"name\":\"admin\", \"email\":\"role@gmail.com\"}") String filterProperties,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) SortEnumDTO direction,
            @RequestParam(required = false, defaultValue = "createAt") String... sortProperties) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
