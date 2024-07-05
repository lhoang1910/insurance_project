package com.insurance.business.core.command.service.impl;

import com.insurance.business.core.command.service.EventStoreService;
import com.insurance.business.core.domain.aggregate.QuotationAggregate;
import com.insurance.business.core.domain.entity.EventStoreEntity;
import com.insurance.business.core.domain.repository.EventStoreRepository;
import com.insurance.infrastructure.shared.base.BaseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EventStoreServiceImpl implements EventStoreService {

    @Autowired
    private EventStoreRepository eventStoreRepository;

    @Override
    public void save(QuotationAggregate aggregate, BaseEvent event) {
        long version = eventStoreRepository.numberOfEvent(aggregate.getId()) + 1;

        EventStoreEntity eventStoreEntity = EventStoreEntity.builder()
                .id(UUID.randomUUID().toString())
                .aggregateId(aggregate.getId())
                .updatedAt(new Date())
                .aggregateType(event.getClass().getSimpleName())
                .updatedBy(aggregate.getUpdatedBy())
                .data(aggregate)
                .version(version)
                .build();
        eventStoreRepository.save(eventStoreEntity);
    }

    @Override
    public QuotationAggregate load(String id) {
        Optional<EventStoreEntity> optional = eventStoreRepository.findFirstByVersion(id);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.map(EventStoreEntity::getData).orElse(null);
    }
}
