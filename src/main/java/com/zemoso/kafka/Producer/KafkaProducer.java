package com.zemoso.kafka.Producer;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by sowmya on 20/07/2017.
 */

/**
 * Template producer class used to send data to kafka
 *
 * Setup and creation of the KafkaTemplate and Producer beans is automatically done by Spring Boot
 *
 */
@Component
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, JsonNode> kafkaTemplate;

    /**
     * Method used to send messages
     * Please refer to http://docs.spring.io/autorepo/docs/spring-kafka-dist/1.0.0.RELEASE/api/org/springframework/kafka/core/KafkaTemplate.html
     *  for various send options
     * @param topic topic to post the data to
     * @param data data
     */
    public void send(String topic, JsonNode data) {
        // the KafkaTemplate provides asynchronous send methods returning a Future
        ListenableFuture<SendResult<String, JsonNode>> future = kafkaTemplate.send(topic, data);

        // register a callback with the listener to receive the result of the send asynchronously
        future.addCallback(new ListenableFutureCallback<SendResult<String, JsonNode>>() {

            @Override
            public void onSuccess(SendResult<String, JsonNode> result) {
                LOGGER.info("sent message='{}' with offset={}", data,
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("unable to send message='{}'", data, ex);
            }
        });

        // or, to block the sending thread to await the result, invoke the future's get() method
    }
}
