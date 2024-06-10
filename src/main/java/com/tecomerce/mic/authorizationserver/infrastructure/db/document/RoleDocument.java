package com.tecomerce.mic.authorizationserver.infrastructure.db.document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("role")
@Document(collection = "roles")
public class RoleDocument {

    @Id
    private String id;
    private String role;
}
