package com.insurance.business.ac.command.service.impl;

import com.insurance.business.ac.command.service.EventStoreService;
import com.insurance.business.ac.domain.aggregate.UserAggregate;
import com.insurance.business.ac.domain.entity.EventStoreEntity;
import com.insurance.business.ac.domain.repository.EventStoreRepository;
import com.insurance.infrastructure.shared.base.BaseEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EventStoreServiceImpl implements EventStoreService {

    private final EventStoreRepository eventStoreRepository;

    @Override
    public void save(UserAggregate aggregate, BaseEvent event) {

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
    public UserAggregate load(String id) {
        Optional<EventStoreEntity> optional = eventStoreRepository.findFirstByVersion(id);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.map(EventStoreEntity::getData).orElse(null);
    }

}
