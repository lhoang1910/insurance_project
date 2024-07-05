package com.insurance.business.ac.query.service.impl;

import com.insurance.business.ac.domain.entity.UserEntity;
import com.insurance.business.ac.domain.repository.UserRepository;
import com.insurance.business.ac.query.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean exitByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
