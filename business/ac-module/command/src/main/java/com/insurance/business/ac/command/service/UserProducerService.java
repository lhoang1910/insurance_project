package com.insurance.business.ac.command.service;


import com.insurance.infrastructure.shared.base.BaseEvent;

public interface UserProducerService {
    void produce(String topic, BaseEvent event);
}
