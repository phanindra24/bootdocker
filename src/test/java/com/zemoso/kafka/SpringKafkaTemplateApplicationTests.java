package com.zemoso.kafka;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zemoso.kafka.Consumer.KafkaConsumer;
import com.zemoso.kafka.Producer.KafkaProducer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaTemplateApplicationTests {

	private static String BOOT_TOPIC = "mirthProducertest4";

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private KafkaConsumer kafkaConsumer;

	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	/*@ClassRule
	*//**
	 * embedded Kafka broker which is started via a JUnit @ClassRule.
	 *//*
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, BOOT_TOPIC);*/

	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("spring.kafka.bootstrap-servers", embeddedKafka.getBrokersAsString());
	}*/

	/*@Before
	public void setUp() throws Exception {
		// wait until the partitions are assigned
		for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
				.getListenerContainers()) {
			ContainerTestUtils.waitForAssignment(messageListenerContainer,
					embeddedKafka.getPartitionsPerTopic());
		}
	}*/

	@Test
	public void testReceive() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		ArrayNode arrayNode = mapper.createArrayNode();

		/**
		 * Create three JSON Objects objectNode1, objectNode2, objectNode3
		 * Add all these three objects in the array
		 */

		ObjectNode objectNode1 = mapper.createObjectNode();
		objectNode1.put("bookName", "Java");
		objectNode1.put("price", "100");
		kafkaProducer.send(BOOT_TOPIC, objectNode1);

		kafkaConsumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(kafkaConsumer.getLatch().getCount()).isEqualTo(0);
	}

}