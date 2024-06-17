package com.tecomerce.mic.authorizationserver.api.controller;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.application.usecase.impl.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/clients")
@Tags(value = {@Tag(name = "Client", description = "Client API")})
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Void> createClient(@RequestBody ClientDTO dto) {
        clientService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{delete}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
