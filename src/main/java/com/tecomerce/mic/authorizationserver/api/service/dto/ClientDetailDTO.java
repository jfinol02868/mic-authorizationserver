package com.tecomerce.mic.authorizationserver.api.service.dto;


import com.tecomerce.mic.authorizationserver.infrastructure.db.document.AuthorizationGrantTypeDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ClientAuthenticationMethodDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.RedirectUriDocument;
import com.tecomerce.mic.authorizationserver.infrastructure.db.document.ScopeDocument;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class ClientDetailDTO {

    @Schema(description = "Id of the Client", example = "AUTHORIZATION::CLIENT::68B68D3C-8440-48B0-A0CF-DCB40EA8B28D::DES")
    private String id;
    @Schema(description = "Client Id", example = "client")
    private String clientId;
    @Schema(description = "Client Secret", example = "secret")
    private String clientSecret;
    @ArraySchema(schema = @Schema(implementation = ClientAuthenticationMethodDocument.class))
    private List<ClientAuthenticationMethodDocument> authenticationMethods;
    @ArraySchema(schema = @Schema(implementation = AuthorizationGrantTypeDocument.class))
    private List<AuthorizationGrantTypeDocument> authorizationGrantTypes;
    @ArraySchema(schema = @Schema(implementation = RedirectUriDocument.class))
    private List<RedirectUriDocument> redirectUris;
    @ArraySchema(schema = @Schema(implementation = ScopeDocument.class))
    private List<ScopeDocument> scopes;
    @Schema(description = "Require Proof Key", example = "false")
    private Boolean requireProofKey;

}
