package com.tecomerce.mic.authorizationserver.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedirectUri {

    private String id;
    private String uri;
    private String description;
}
