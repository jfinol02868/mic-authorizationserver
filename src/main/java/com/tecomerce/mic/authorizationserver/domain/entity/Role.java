package com.tecomerce.mic.authorizationserver.domain.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    private String id;
    private String roleName;
    private List<User> users;

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
