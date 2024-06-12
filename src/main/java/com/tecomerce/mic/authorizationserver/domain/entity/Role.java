package com.tecomerce.mic.authorizationserver.domain.entity;

import com.tecomerce.mic.authorizationserver.domain.enums.RoleName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private String id;
    private String roleName;
    private List<User> users;
}
