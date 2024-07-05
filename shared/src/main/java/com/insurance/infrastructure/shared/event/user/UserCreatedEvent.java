package com.insurance.infrastructure.shared.event.user;

import com.insurance.infrastructure.shared.base.BaseEvent;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedEvent extends BaseEvent {
    private String id;
    private String userCode;
    private String username;
    private String password;
    private Integer department;
    private Integer workSite;
    private Boolean isDeleted;

    @Builder
    public UserCreatedEvent(Date updatedAt, String updatedBy, String id, String userCode, String username, String password, Integer department, Integer workSite, Boolean isDeleted) {
        super(updatedAt, updatedBy);
        this.id = id;
        this.userCode = userCode;
        this.username = username;
        this.password = password;
        this.department = department;
        this.workSite = workSite;
        this.isDeleted = isDeleted;
    }

}
