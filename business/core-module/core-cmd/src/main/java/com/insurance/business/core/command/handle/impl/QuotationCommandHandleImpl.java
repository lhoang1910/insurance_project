package com.insurance.business.core.command.handle.impl;

import com.insurance.business.core.command.handle.QuotationCommandHandle;
import com.insurance.business.core.command.service.EventStoreService;
import com.insurance.business.core.domain.aggregate.QuotationAggregate;
import com.insurance.infrastructure.shared.command.quotation.CreateQuotationCommand;
import com.insurance.infrastructure.shared.command.quotation.DeleteQuotationCommand;
import com.insurance.infrastructure.shared.command.quotation.UpdateQuotationCommand;
import com.insurance.infrastructure.shared.event.quotation.QuotationCreatedEvent;
import com.insurance.infrastructure.shared.event.quotation.QuotationDeletedEvent;
import com.insurance.infrastructure.shared.event.quotation.QuotationUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class QuotationCommandHandleImpl implements QuotationCommandHandle {

    @Autowired
    private EventStoreService eventStoreService;

    @Override
    public void handle(CreateQuotationCommand command) {
        QuotationAggregate aggregate = new QuotationAggregate();
        QuotationCreatedEvent event = aggregate.apply(command);
        eventStoreService.save(aggregate, event);
    }

    @Override
    public void handle(UpdateQuotationCommand command) {
        QuotationAggregate aggregate = eventStoreService.load(command.getId());
        QuotationUpdatedEvent event = aggregate.apply(command);
        eventStoreService.save(aggregate, event);
    }

    @Override
    public void handle(DeleteQuotationCommand command) {
        QuotationAggregate aggregate = eventStoreService.load(command.getId());
        QuotationDeletedEvent event = aggregate.apply(command);
        eventStoreService.save(aggregate, event);
    }
}
