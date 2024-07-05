package com.insurance.business.ac.flow.handler.impl;

import com.insurance.business.ac.domain.entity.UserEntity;
import com.insurance.business.ac.domain.repository.UserRepository;
import com.insurance.business.ac.flow.handler.UserEventHandler;
import com.insurance.infrastructure.shared.event.user.UserCreatedEvent;
import com.insurance.infrastructure.shared.event.user.UserDeletedEvent;
import com.insurance.infrastructure.shared.event.user.UserUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEventHandlerImpl implements UserEventHandler {

    private final UserRepository userRepository;

    @Override
    public void handle(UserCreatedEvent event) {
        userRepository.save(UserEntity.builder()
                .id(event.getId())
                .department(event.getDepartment())
                .workSite(event.getWorkSite())
                .userCode(event.getUserCode())
                .username(event.getUsername())
                .isDeleted(event.getIsDeleted())
                .password(event.getPassword())
                .build());
    }

    @Override
    public void handle(UserUpdatedEvent event) {
        Optional<UserEntity> userEntity = userRepository.findById(event.getId());
        if (userEntity.isEmpty()) throw new EntityNotFoundException("Not Found!");

        UserEntity entity = userEntity.get();
        entity.setPassword(event.getPassword());
        entity.setDepartment(event.getDepartment());
        entity.setWorkSite(event.getWorkSite());
        userRepository.save(entity);
    }

    @Override
    public void handle(UserDeletedEvent event) {
        Optional<UserEntity> userEntity = userRepository.findById(event.getId());
        if (userEntity.isEmpty()) throw new EntityNotFoundException("Not Found!");

        UserEntity entity = userEntity.get();
        entity.setIsDeleted(true);
        userRepository.save(entity);

    }
}
