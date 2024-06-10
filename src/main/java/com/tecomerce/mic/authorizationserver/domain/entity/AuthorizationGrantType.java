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
public class AuthorizationGrantType {

        private String id;
        private String value;
        private String description;
}
