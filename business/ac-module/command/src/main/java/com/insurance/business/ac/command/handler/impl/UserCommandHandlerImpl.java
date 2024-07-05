package com.insurance.business.ac.command.handler.impl;

import com.insurance.business.ac.command.handler.UserCommandHandler;
import com.insurance.business.ac.command.service.EventStoreService;
import com.insurance.business.ac.command.service.UserProducerService;
import com.insurance.business.ac.domain.aggregate.UserAggregate;
import com.insurance.infrastructure.shared.command.user.CreateUserCommand;
import com.insurance.infrastructure.shared.command.user.DeleteUserCommand;
import com.insurance.infrastructure.shared.command.user.UpdateUserCommand;
import com.insurance.infrastructure.shared.event.user.UserCreatedEvent;
import com.insurance.infrastructure.shared.event.user.UserDeletedEvent;
import com.insurance.infrastructure.shared.event.user.UserUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserCommandHandlerImpl implements UserCommandHandler {

    private final EventStoreService eventStoreService;
    private final UserProducerService producerService;

    @Override
    public void handle(CreateUserCommand command) {
        UserAggregate aggregate = new UserAggregate();
        UserCreatedEvent event = aggregate.apply(command);
        eventStoreService.save(aggregate, event);
        producerService.produce(UserCreatedEvent.class.getSimpleName(), event);
    }

    @Override
    public void handle(UpdateUserCommand command) {
        UserAggregate aggregate = eventStoreService.load(command.getId());
        UserUpdatedEvent event = aggregate.apply(command);
        eventStoreService.save(aggregate, event);
        producerService.produce(UserUpdatedEvent.class.getSimpleName(), event);
    }

    @Override
    public void handle(DeleteUserCommand command) {
        UserAggregate aggregate = eventStoreService.load(command.getId());
        UserDeletedEvent event = aggregate.apply(command);
        eventStoreService.save(aggregate, event);
        producerService.produce(DeleteUserCommand.class.getSimpleName(), event);
    }
}
