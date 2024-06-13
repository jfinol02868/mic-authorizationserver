package com.tecomerce.mic.authorizationserver.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    private String id;
    private String username;
    private String password;
    private List<Role> roles;
    private boolean expired = false;
    private boolean locked = false;
    private boolean credentialsExpired = false;
    private boolean disabled = false;


}
