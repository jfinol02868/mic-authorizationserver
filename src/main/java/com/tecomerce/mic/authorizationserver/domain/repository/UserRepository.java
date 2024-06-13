package com.tecomerce.mic.authorizationserver.domain.repository;

import com.tecomerce.mic.authorizationserver.domain.entity.User;

public interface UserRepository extends BaseRepository<User, String> {

    User findByUsername(String username);
}
