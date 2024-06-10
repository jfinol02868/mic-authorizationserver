package com.tecomerce.mic.authorizationserver.api.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientAuthenticationMethodDTO {

        @Schema(description = "Id of the ClientAuthenticationMethod", example = "AUTHORIZATION::CLIENTAUTHENTICATIONMETHOD::68B68D3C-8440-48B0-A0CF-DCB40EA8B28D::DES")
        private String id;
        @Schema(description = "Name of the ClientAuthenticationMethod", example = "client_secret_basic")
        private String value;
        @Schema(description = "Description of the ClientAuthenticationMethod", example = "Client Authentication Method Description")
        private String description;
}
