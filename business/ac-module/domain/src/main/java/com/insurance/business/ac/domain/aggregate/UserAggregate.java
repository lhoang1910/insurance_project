package com.insurance.business.ac.domain.aggregate;

import com.insurance.infrastructure.shared.base.BaseAggregate;
import com.insurance.infrastructure.shared.command.user.CreateUserCommand;
import com.insurance.infrastructure.shared.command.user.DeleteUserCommand;
import com.insurance.infrastructure.shared.command.user.UpdateUserCommand;
import com.insurance.infrastructure.shared.event.user.UserCreatedEvent;
import com.insurance.infrastructure.shared.event.user.UserDeletedEvent;
import com.insurance.infrastructure.shared.event.user.UserUpdatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserAggregate extends BaseAggregate{

    private String id;
    private String userCode;
    private String username;
    private String password;
    private Integer department;
    private Integer workSite;
    private Boolean isDeleted;
    private String updatedBy;

    public UserCreatedEvent apply(CreateUserCommand command) {

        this.id = UUID.randomUUID().toString();
        this.userCode = command.getUserCode();
        this.username = command.getUsername();
        this.password = command.getPassword();
        this.department = command.getDepartment();
        this.workSite = command.getWorkSite();
        this.isDeleted = false;
        this.updatedBy = command.getUpdatedBy();

        return UserCreatedEvent.builder()
                .id(this.id)
                .userCode(this.userCode)
                .username(this.username)
                .password(this.password)
                .department(this.department)
                .workSite(this.workSite)
                .isDeleted(this.isDeleted)
                .updatedAt(new Date())
                .updatedBy(command.getUpdatedBy())
                .build();
    }

    public UserUpdatedEvent apply(UpdateUserCommand command) {

        this.id = command.getId();
        this.password = command.getPassword();
        this.department = command.getDepartment();
        this.workSite = command.getWorkSite();
        this.updatedBy = command.getUpdatedBy();

        return UserUpdatedEvent.builder()
                .id(this.id)
                .password(this.password)
                .department(this.department)
                .workSite(this.workSite)
                .updatedAt(new Date())
                .updatedBy(command.getUpdatedBy())
                .build();
    }

    public UserDeletedEvent apply(DeleteUserCommand command) {
        this.id = command.getId();
        this.updatedBy = command.getUpdatedBy();

        return UserDeletedEvent.builder()
                .id(this.id)
                .updatedBy(this.updatedBy)
                .updatedAt(new Date())
                .build();
    }


}
