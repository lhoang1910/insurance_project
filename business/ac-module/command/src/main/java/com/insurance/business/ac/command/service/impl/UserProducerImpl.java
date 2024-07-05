package com.insurance.business.ac.command.service.impl;

import com.insurance.business.ac.command.service.UserProducerService;
import com.insurance.infrastructure.shared.base.BaseEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserProducerImpl implements UserProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void produce(String topic, BaseEvent event) {
        kafkaTemplate.send(topic, event);
    }
}
