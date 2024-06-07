package com.tecomerce.mic.authorizationserver.domain.entity;

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
public class ClientAuthenticationMethod {

        private String id;
        private String name;
        private String description;
}
