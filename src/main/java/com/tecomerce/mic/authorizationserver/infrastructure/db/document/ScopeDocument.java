package com.tecomerce.mic.authorizationserver.infrastructure.db.document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("scope")
@Document(collection = "scopes")
public class ScopeDocument {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
}
