package com.tecomerce.mic.authorizationserver.api.service.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @Schema(description = "Client id", example = "AUTHORIZATION::CLIENT::781636A3-7DEF-48E8-BD18-314B37E2164D::DES")
    private String id;
    @Schema(description = "Client name", example = "client")
    private String clientId;
    @Schema(description = "Client secret", example = "secret")
    private String clientSecret;
    @Schema(description = "Client authentication methods", example = "[\"client_secret_basic\"]")
    private Set<String> authenticationMethods;
    @Schema(description = "Client authorization grant types", example = "[\"authorization_code\", \"refresh_token\", \"client_credentials\"]")
    private Set<String> authorizationGrantTypes;
    @Schema(description = "Client redirect uris", example = "[\"https://oauthdebugger.com/debug\"]")
    private Set<String> redirectUris;
    @Schema(description = "Client scopes", example = "[\"openid\"]")
    private Set<String> scopes;
    @Schema(description = "Client require proof key", example = "false")
    private boolean requireProofKey;

}
