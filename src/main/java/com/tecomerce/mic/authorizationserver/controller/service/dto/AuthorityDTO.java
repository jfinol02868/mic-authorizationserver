package com.tecomerce.mic.authorizationserver.controller.service.dto;


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
public class AuthorityDTO {

    @Schema(description = "Authority ID", example = "AUTHORIZATION::AUTHORITY::8A94D4C3-4F6C-4A9F-B9E1-1234567890AB::DES")
    private String id;

    @NotNull(message = "The code cannot be null or empty.")
    @Schema(description = "Authority code", example = "USER_READ")
    private String code;

    @NotNull(message = "The name cannot be null or empty.")
    @Schema(description = "Authority name", example = "User Read Permission")
    private String name;
}
