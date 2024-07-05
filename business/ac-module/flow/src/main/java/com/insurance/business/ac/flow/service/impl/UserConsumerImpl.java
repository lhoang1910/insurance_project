package com.insurance.business.ac.flow.service.impl;

import com.insurance.business.ac.domain.repository.UserRepository;
import com.insurance.business.ac.flow.handler.UserEventHandler;
import com.insurance.business.ac.flow.service.UserConsumerService;
import com.insurance.infrastructure.shared.base.BaseEvent;
import com.insurance.infrastructure.shared.event.user.UserCreatedEvent;
import com.insurance.infrastructure.shared.event.user.UserDeletedEvent;
import com.insurance.infrastructure.shared.event.user.UserUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserConsumerImpl implements UserConsumerService {

    private final UserRepository userRepository;
    private final UserEventHandler eventHandler;

    @Retryable(
            value = { EntitySaveException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    @Transactional
    @KafkaListener(topics = {"UserCreatedEvent"}, groupId = "insuranceConsumer")
    @Override
    public void consume(UserCreatedEvent event) {
        eventHandler.handle(event);
    }

    @Retryable(
            value = { EntitySaveException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    @Transactional
    @KafkaListener(topics = {"UserUpdatedEvent"}, groupId = "insuranceConsumer")
    @Override
    public void consume(UserUpdatedEvent event) {
        eventHandler.handle(event);
    }

    @Retryable(
            value = { EntitySaveException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    @Transactional
    @KafkaListener(topics = {"UserDeletedEvent"}, groupId = "insuranceConsumer")
    @Override
    public void consume(UserDeletedEvent event) {
        eventHandler.handle(event);
    }

    @Recover
    public void recover(EntitySaveException e, BaseEvent event) {
        System.out.println("Failed to save user with event. Error: " + e);
    }
}
