package com.tecomerce.mic.authorizationserver.api.service.dto;


import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetailDTO {

    @Schema(description = "Id of the Client", example = "AUTHORIZATION::CLIENT::68B68D3C-8440-48B0-A0CF-DCB40EA8B28D::DES")
    private String id;
    @Schema(description = "Client Id", example = "client")
    private String clientId;
    @Schema(description = "Client Secret", example = "secret")
    private String clientSecret;
    @ArraySchema(schema = @Schema(implementation = ClientAuthenticationMethodDTO.class))
    private List<ClientAuthenticationMethodDTO> authenticationMethods;
    @ArraySchema(schema = @Schema(implementation = AuthorizationGrantTypeDTO.class))
    private List<AuthorizationGrantTypeDTO> authorizationGrantTypes;
    @ArraySchema(schema = @Schema(implementation = RedirectUriDTO.class))
    private List<RedirectUriDTO> redirectUris;
    @ArraySchema(schema = @Schema(implementation = ScopeDTO.class))
    private List<ScopeDTO> scopes;
    @Schema(description = "Require Proof Key", example = "false")
    private Boolean requireProofKey;

}
