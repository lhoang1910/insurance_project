package com.insurance.infrastructure.shared.command.user;

import com.insurance.infrastructure.shared.base.BaseCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DeleteUserCommand extends BaseCommand {

    String id;
    String updatedBy;

    public DeleteUserCommand(String id) {
        this.id = id;
    }
}
