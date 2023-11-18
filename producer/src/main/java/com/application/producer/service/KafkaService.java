package com.application.producer.service;


import dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    public void sendMessageToTopic(String message) {
//        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send("demo-topic",message);
//        completableFuture.whenComplete((result, ex)->{
//            if (ex == null) {
//                System.out.println("Sent message=[" + message +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            } else {
//                System.out.println("Unable to send message=[" +
//                        message + "] due to : " + ex.getMessage());
//            }
//        });
        kafkaTemplate.send("demo-topic" , 2 , null , message+ "hello from topic 2 ");
        kafkaTemplate.send("demo-topic" , 3 , null , message + "hello from topic 3");
        kafkaTemplate.send("demo-topic" , 4 , null , message +"hello 3");
        kafkaTemplate.send("demo-topic" , 5 , null , message +"hello 4");
        kafkaTemplate.send("demo-topic" , 1, null , message + "hello 5");


    }
    public void sendEventsToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("demo-test2", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + customer.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            customer.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : "+ ex.getMessage());
        }
    }



}
