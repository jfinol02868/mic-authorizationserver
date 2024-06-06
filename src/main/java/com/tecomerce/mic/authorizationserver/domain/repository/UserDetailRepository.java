package com.tecomerce.mic.authorizationserver.domain.repository;

import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;

public interface UserDetailRepository {

    public UserDetail findByUsername(String username);
}
