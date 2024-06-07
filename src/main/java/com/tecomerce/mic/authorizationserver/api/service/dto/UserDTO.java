package com.tecomerce.mic.authorizationserver.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Schema(description = "User ID,", example = "AUTHORIZATION::USER::8A94D4C3-4F6C-4A9F-B9E1-1234567890AB::DES")
    private String id;

    @NotNull(message = "The username cannot be null or empty.")
    @Schema(description = "User name.", example = "john_doe")
    private String username;

    @NotNull(message = "The password cannot be null or empty.")
    @Schema(description = "User password.", example = "password123")
    private String password;

    @Schema(description = "User roles.", example = "[\"AUTHORIZATION::ROLE::8A94D4C3-4F6C-4A7F-B9E1-1234567890AB::DES\", \"AUTHORIZATION::ROLE::8A95D4C3-4F6C-4A9F-B9E1-1234567890AB::DES\"]")
    private List<String> roles;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Expired user.", example = "false")
    private boolean expired = false;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Locked user.", example = "false")
    private boolean locked = false;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Credentials expired user.", example = "false")
    private boolean credentialsExpired = false;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Disabled user.", example = "false")
    private boolean disabled = false;
}
