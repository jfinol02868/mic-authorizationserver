package com.tecomerce.mic.authorizationserver.domain.entity;

import com.tecomerce.mic.authorizationserver.api.service.dto.RoleDTO;
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
    private List<RoleDTO> roles;
    private boolean expired = false;
    private boolean locked = false;
    private boolean credentialsExpired = false;
    private boolean disabled = false;
}
