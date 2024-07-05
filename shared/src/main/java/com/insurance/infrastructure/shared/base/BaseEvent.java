package com.insurance.infrastructure.shared.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BaseEvent {

    private Date updatedAt;
    private String updatedBy;

    public BaseEvent(Date updatedAt, String updatedBy) {
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
}
