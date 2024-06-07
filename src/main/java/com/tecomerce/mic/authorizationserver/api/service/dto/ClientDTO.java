package com.tecomerce.mic.authorizationserver.api.service.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private String id;
    private String clientId;
    private String clientSecret;
    private List<String> authenticationMethods;
    private List<String> authorizationGrantTypes;
    private List<String> redirectUris;
    private List<String> scopes;
    private Boolean requireProofKey;

}
