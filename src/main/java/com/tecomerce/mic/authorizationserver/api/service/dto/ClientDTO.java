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
    @Schema(description = "Authentication Methods", example = "[\"AUTHORIZATION::CLIENTAUTHENTICATIONMETHOD::619FF8AE-749D-47BF-8A7C-CB0B7BE9D5B5::DES\"]")
    private List<String> authenticationMethods;
    @Schema(description = "Authorization Grant Types", example = "[\"AUTHORIZATION::AUTHORIZATIONGRANTTYPE::F0E072C2-7097-41CE-8BAA-9325A722FE2D::DES\", \"AUTHORIZATION::AUTHORIZATIONGRANTTYPE::F0E072C2-7097-41CE-8BAA-9325A724FE2D::DES\", \"AUTHORIZATION::AUTHORIZATIONGRANTTYPE::F0E072C2-7097-41CE-8BAB-9325A722FE2D::DES\"]")
    private List<String> authorizationGrantTypes;
    @Schema(description = "Redirect Uris", example = "[\"AUTHORIZATION::REDIRECTURI::8E13F0AA-BF62-4E32-B49E-9CD8FE768636::DES\"]")
    private List<String> redirectUris;
    @Schema(description = "Scopes", example = "[\"AUTHORIZATION::SCOPE::901ED8FD-55B6-4087-9BC1-DF3788F72714::DES\"]")
    private List<String> scopes;
    @Schema(description = "Require Proof Key", example = "false")
    private Boolean requireProofKey;

}
