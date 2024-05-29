package com.tecomerce.mic.authorizationserver.repository.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserDocument {

    private String id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private List<RoleDocument> roles;
}
