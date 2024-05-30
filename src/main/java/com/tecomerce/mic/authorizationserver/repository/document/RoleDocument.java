package com.tecomerce.mic.authorizationserver.repository.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("role")
@Document(collection = "roles")
public class RoleDocument {

    private String id;
    private String name;
    private List<String> authorities;
}
