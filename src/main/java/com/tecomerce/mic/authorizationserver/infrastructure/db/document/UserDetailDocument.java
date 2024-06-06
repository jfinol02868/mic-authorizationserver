package com.tecomerce.mic.authorizationserver.infrastructure.db.document;

import com.tecomerce.mic.authorizationserver.domain.entity.Role;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("user")
@Document(collection = "users")
public class UserDetailDocument {

    @Id
    private String id;
    private String username;
    private String password;
    @DocumentReference(collection = "roles")
    private List<Role> roles;
    private boolean expired = false;
    private boolean locked = false;
    private boolean credentialsExpired = false;
    private boolean disabled = false;
}
