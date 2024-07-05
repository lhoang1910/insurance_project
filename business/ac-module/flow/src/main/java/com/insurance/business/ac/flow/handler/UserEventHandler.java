package com.insurance.business.ac.flow.handler;

import com.insurance.infrastructure.shared.event.user.UserCreatedEvent;
import com.insurance.infrastructure.shared.event.user.UserDeletedEvent;
import com.insurance.infrastructure.shared.event.user.UserUpdatedEvent;

public interface UserEventHandler {
    void handle(UserCreatedEvent event);
    void handle(UserUpdatedEvent event);
    void handle(UserDeletedEvent event);
}
