package com.tecomerce.mic.authorizationserver.application.usecase.impl;

import com.tecomerce.mic.authorizationserver.domain.repository.RoleRepository;
import com.tecomerce.mic.authorizationserver.domain.repository.UserDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDetailRepository userDetailRepository;
    private final RoleRepository roleRepository;



}
