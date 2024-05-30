package com.tecomerce.mic.authorizationserver.repository.document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserDetailDocument {

    @Id
    private String id;
    private String userName;
    private String password;
    private String email;
    private boolean enabled;
    private List<RoleDocument> roles;
}
