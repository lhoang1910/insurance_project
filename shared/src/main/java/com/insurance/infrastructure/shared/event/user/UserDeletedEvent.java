package com.insurance.infrastructure.shared.event.user;

import com.insurance.infrastructure.shared.base.BaseEvent;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserDeletedEvent extends BaseEvent {
    private String id;
    private Boolean isDeleted = true;

    @Builder
    public UserDeletedEvent(Date updatedAt, String id, String updatedBy) {
        super(updatedAt, updatedBy);
        this.id = id;
    }
}