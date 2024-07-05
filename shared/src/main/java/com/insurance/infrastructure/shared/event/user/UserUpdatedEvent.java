package com.insurance.infrastructure.shared.event.user;

import com.insurance.infrastructure.shared.base.BaseEvent;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserUpdatedEvent extends BaseEvent {
    private String id;
    private String password;
    private Integer department;
    private Integer workSite;

    @Builder
    public UserUpdatedEvent(String id, String password, Integer department, Integer workSite, Date updatedAt, String updatedBy) {
        super(updatedAt, updatedBy);
        this.id = id;
        this.password = password;
        this.department = department;
        this.workSite = workSite;

    }
}
