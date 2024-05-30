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
@TypeAlias("user")
@Document(collection = "users")
public class UserDocument {

    private String id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private List<String> roles;
}
