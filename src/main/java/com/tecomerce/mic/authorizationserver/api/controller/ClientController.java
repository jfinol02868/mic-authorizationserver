package com.tecomerce.mic.authorizationserver.api.controller;

import com.tecomerce.mic.authorizationserver.api.service.dto.ClientDTO;
import com.tecomerce.mic.authorizationserver.application.usecase.impl.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Void> createClient(@RequestBody ClientDTO dto) {
        clientService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
