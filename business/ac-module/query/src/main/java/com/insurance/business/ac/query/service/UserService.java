package com.insurance.business.ac.query.service;

import com.insurance.business.ac.domain.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    boolean exitByUsername(String username);

    Optional<UserEntity> findUserByUsername(String username);

}
