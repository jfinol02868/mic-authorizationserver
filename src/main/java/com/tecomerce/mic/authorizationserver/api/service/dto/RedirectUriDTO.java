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
public class RedirectUriDTO {

    @Schema(description = "Id of the RedirectUri", example = "AUTHORIZATION::REDIRECTURI::68B68D3C-8440-48B0-A0CF-DCB40EA8B28D::DES")
    private String id;
    @Schema(description = "Uri of the RedirectUri", example = "https://oauthdebugger.com/debug")
    private String uri;
    @Schema(description = "Description of the RedirectUri", example = "Redirect Uri Description")
    private String description;
}
