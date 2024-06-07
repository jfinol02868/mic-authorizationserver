package com.tecomerce.mic.authorizationserver.domain.repository;

import com.tecomerce.mic.authorizationserver.domain.entity.ClientDetail;

public interface ClientDetailRepository {

    public ClientDetail getClientDetail(String id);

}
