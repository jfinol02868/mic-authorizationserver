package com.tecomerce.mic.authorizationserver.service.usecase.impl;

import com.tecomerce.mic.authorizationserver.repository.UserDetailRepositoryAdapter;
import com.tecomerce.mic.authorizationserver.repository.mapper.UserDetailMapper;
import com.tecomerce.mic.authorizationserver.service.entity.User;
import com.tecomerce.mic.authorizationserver.service.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserUseCaseImpl implements UserUseCase {

    private final UserDetailMapper uDMapper;
    private final UserDetailRepositoryAdapter uDRepository;


    @Override
    public User findByUsername(String userName) {
        return uDMapper.toEntity(uDRepository.findByUsername(userName));
    }
}
