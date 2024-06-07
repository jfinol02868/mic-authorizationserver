package com.tecomerce.mic.authorizationserver.infrastructure.db.document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("redirectUri")
@Document(collection = "redirectUris")
public class RedirectUriDocument {

    @Id
    private String id;
    private String uri;
    private String description;
}
