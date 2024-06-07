package com.tecomerce.mic.authorizationserver.api.service.dto;

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

    private String id;
    private String uri;
    private String description;
}
