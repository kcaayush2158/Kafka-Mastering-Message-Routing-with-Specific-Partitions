package com.application.consumer.consumer;

import com.application.consumer.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "demo-topic",groupId = "application-group")
    public void consumeEvents(String customer){
        log.info("consumer consume the events {} ", customer);
    }
}
