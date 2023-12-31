package com.application.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "demo-topic",groupId = "application-group",topicPartitions = {@TopicPartition(topic = "demo-topic", partitions = "2")})
    public void consumeEvents(String customer){
        log.info("consumer consume the events {} ", customer);
    }
}
