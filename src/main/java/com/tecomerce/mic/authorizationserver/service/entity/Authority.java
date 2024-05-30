package com.tecomerce.mic.authorizationserver.service.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Authority implements GrantedAuthority {

    private String id;
    private String code;
    private String name;

    @Override
    public String getAuthority() {
        return this.getName();
    }
}
