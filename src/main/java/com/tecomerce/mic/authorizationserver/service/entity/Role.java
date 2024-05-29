package com.tecomerce.mic.authorizationserver.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private String id;
    private String name;
    private List<Authority> authorities;

}
