package com.tecomerce.mic.authorizationserver.api.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    @Schema(description = "Role ID.", example = "AUTHORIZATION::ROLE::8A94D4C3-4F6C-4A9F-B9E1-1234567890AB::DES")
    private String id;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Role name.", example = "ROLE_USER")
    private String name;
}
