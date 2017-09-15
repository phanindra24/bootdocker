package com.zemoso.kafka;

import com.zemoso.kafka.Consumer.KafkaConsumer;
import com.zemoso.kafka.Producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringKafkaTemplateApplication {
//	@Autowired
//	private KafkaProducer kafkaProducer;
//
//	@Autowired
//	private KafkaConsumer kafkaConsumer;
//
//	@Autowired
//	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaTemplateApplication.class, args);


	}
//	@Override
//	public void run(String... arg0) throws Exception {
//		//TEST pub/sub kafka topic
////		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
////		executor.createThread(kafkaConsumer).start();
////
////		Producer producer = context.getBean("kafkaProducer", Producer.class);
////		for (int i = 0; i < 20; i++) {
////			producer.send("Kafka say hello " + i);
////			Thread.sleep(3000);
////		}
//		this.testReceive();
//	}
//	public void testReceive() throws Exception {
//		kafkaProducer.send("boot.t", "Hello Boot!");
//
//		kafkaConsumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
////		assertThat(kafkaConsumer.getLatch().getCount()).isEqualTo(0);
//	}
}
