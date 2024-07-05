package com.insurance.infrastructure.shared.event.quotation;

import com.insurance.infrastructure.shared.base.BaseEvent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class QuotationDeletedEvent extends BaseEvent {
    private String id;
    private Boolean isDeleted = true;

    @Builder
    public QuotationDeletedEvent(Date updatedAt, String id, String updatedBy) {
        super(updatedAt, updatedBy);
        this.id = id;
    }
}
