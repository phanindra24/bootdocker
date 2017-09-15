package com.zemoso.kafka.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sowmya on 20/07/2017.
 */
@Component
/**
 * Template class to receive data from a Kafka topic
 *
 * setup and creation of the ConcurrentKafkaListenerContainerFactory and KafkaMessageListenerContainer beans is
 * automatically done by Spring Boot
 *
 */
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    /**
     * Method used to receive data from the configured topic
     * @param consumerRecord
     * @param partition - partition from which the message wsa received (sample on how to read from message headers)
     */
    // Can listen to multiple topics - ex: @KafkaListener(topics = "topic1, topic2", group = "foo")
    @KafkaListener(topics = "${topic.boot}")
    public void receive(ConsumerRecord<?, ?> consumerRecord, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        LOGGER.info("received data='{}', partition = {}", consumerRecord.value(), partition);
//return        consumerRecord.Value();
//        latch.countDown();
    }
}

