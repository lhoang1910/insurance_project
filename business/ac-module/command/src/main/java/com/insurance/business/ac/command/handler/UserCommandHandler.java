package com.insurance.business.ac.command.handler;

import com.insurance.infrastructure.shared.command.user.CreateUserCommand;
import com.insurance.infrastructure.shared.command.user.DeleteUserCommand;
import com.insurance.infrastructure.shared.command.user.UpdateUserCommand;

public interface UserCommandHandler {
    void handle(CreateUserCommand command);
    void handle(UpdateUserCommand command);
    void handle(DeleteUserCommand command);
}
