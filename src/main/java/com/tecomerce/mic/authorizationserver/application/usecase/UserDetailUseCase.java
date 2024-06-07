package com.tecomerce.mic.authorizationserver.application.usecase;

import com.tecomerce.mic.authorizationserver.domain.entity.UserDetail;

public interface UserDetailUseCase {

    public UserDetail findByUsername(String username);

}
