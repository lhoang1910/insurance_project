package com.insurance.business.ac.command.service;


import com.insurance.business.ac.domain.aggregate.UserAggregate;
import com.insurance.infrastructure.shared.base.BaseEvent;

public interface EventStoreService {

    void save(UserAggregate aggregate, BaseEvent event);

    UserAggregate load(String id);


}
