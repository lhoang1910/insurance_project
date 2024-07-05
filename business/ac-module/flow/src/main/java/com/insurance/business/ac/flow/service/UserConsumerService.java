package com.insurance.business.ac.flow.service;

import com.insurance.infrastructure.shared.event.user.UserCreatedEvent;
import com.insurance.infrastructure.shared.event.user.UserDeletedEvent;
import com.insurance.infrastructure.shared.event.user.UserUpdatedEvent;

public interface UserConsumerService {
    void consume (UserCreatedEvent event);
    void consume (UserUpdatedEvent event);
    void consume (UserDeletedEvent event);

}
