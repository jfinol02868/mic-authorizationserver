package com.tecomerce.mic.authorizationserver.application.usecase;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;

public interface ClientDetailUseCase {

        public ClientDetail getClientDetail(String id);
}
