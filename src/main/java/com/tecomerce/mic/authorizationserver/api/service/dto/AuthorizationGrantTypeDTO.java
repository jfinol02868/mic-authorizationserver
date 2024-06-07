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
public class AuthorizationGrantTypeDTO {

        @Schema(description = "Id of the AuthorizationGrantType", example = "AUTHORIZATION::AUTHORIZATIONGRANTTYPE::68B68D3C-8440-48B0-A0CF-DCB40EA8B28D::DES")
        private String id;
        @Schema(description = "Name of the AuthorizationGrantType", example = "authorization_code")
        private String name;
        @Schema(description = "Description of the AuthorizationGrantType", example = "Authorization Grant Type Description")
        private String description;
}
