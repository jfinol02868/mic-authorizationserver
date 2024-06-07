package com.tecomerce.mic.authorizationserver.api.service.dto;


import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Id of the Client", example = "AUTHORIZATION::CLIENT::68B68D3C-8440-48B0-A0CF-DCB40EA8B28D::DES")
    private String id;
    @Schema(description = "Client Id", example = "client")
    private String clientId;
    @Schema(description = "Client Secret", example = "secret")
    private String clientSecret;
    @Schema(description = "Authentication Methods", example = "[\"authorization_code\", \"refresh_token\"], \"client_credentials\"")
    private List<String> authenticationMethods;
    @Schema(description = "Authorization Grant Types", example = "[\"authorization_code\"]")
    private List<String> authorizationGrantTypes;
    @Schema(description = "Redirect Uris", example = "[\"https://oauthdebugger.com/debug\"]")
    private List<String> redirectUris;
    @Schema(description = "Scopes", example = "openid")
    private List<String> scopes;
    @Schema(description = "Require Proof Key", example = "false")
    private Boolean requireProofKey;

}
