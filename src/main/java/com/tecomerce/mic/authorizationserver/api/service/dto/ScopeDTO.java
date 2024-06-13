package com.tecomerce.mic.authorizationserver.api.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScopeDTO {

    @Schema(description = "Id of the Scope", example = "AUTHORIZATION::SCOPE::68B68D3C-8440-48B0-A0CF-DCB40EA8B28D::DES")
    private String id;
    @Schema(description = "Name of the Scope", example = "openid")
    private String name;
    @Schema(description = "Description of the Scope", example = "OpenId Scope Description")
    private String description;
}
