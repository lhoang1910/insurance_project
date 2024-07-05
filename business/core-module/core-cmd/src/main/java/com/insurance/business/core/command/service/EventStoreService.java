package com.insurance.business.core.command.service;

import com.insurance.business.core.domain.aggregate.QuotationAggregate;
import com.insurance.infrastructure.shared.base.BaseEvent;

public interface EventStoreService {

    void save(QuotationAggregate aggregate, BaseEvent event);

    QuotationAggregate load(String id);
}
