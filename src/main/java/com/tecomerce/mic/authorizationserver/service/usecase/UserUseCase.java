package com.tecomerce.mic.authorizationserver.service.usecase;

import com.tecomerce.mic.authorizationserver.service.entity.User;

public interface UserUseCase extends BaseUseCase<User, String> {

    default User findByUsername(String username) {return null; }
}
