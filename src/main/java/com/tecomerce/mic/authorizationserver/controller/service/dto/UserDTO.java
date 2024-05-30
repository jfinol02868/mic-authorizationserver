package com.tecomerce.mic.authorizationserver.controller.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Schema(description = "User ID", example = "AUTHORIZATION::USER::8A94D4C3-4F6C-4A9F-B9E1-1234567890AB::DES")
    private String id;

    @NotNull(message = "The username cannot be null or empty.")
    @Schema(description = "Username", example = "john_doe")
    private String username;

    @NotNull(message = "The password cannot be null or empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Schema(description = "Password", example = "password123")
    private String password;

    @NotNull(message = "The email cannot be null or empty.")
    @Email(message = "The email should be valid.")
    @Schema(description = "Email address", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Indicates if the user is enabled", example = "true")
    private boolean enabled;

    @Schema(description = "List of roles assigned to the user", example = "[\"AUTHORIZATION::ROLE::8A94D4C3-4F6C-4A9F-B9E1-1234567890AB::DES\", \"AUTHORIZATION::ROLE::8A94D4C4-4F6C-4A9F-B9E1-1234567890AB::DES\"]")
    private List<String> roles;
}
