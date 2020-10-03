package com.bankless.app.config;

import kafka.server.KafkaConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("test")
public class TestKafkaConfig {

	@Value("${spring.kafka.server.port}")
	private int serverPort;

	@Value("${embedded.kafka.topics}")
	private String kafkaTopics;

	@Bean
	public EmbeddedKafkaBroker embeddedKafkaBroker() {

		String[] topics = kafkaTopics.split("\\s*,\\s*");
		Map<String, String> brokerProps = Collections.singletonMap(KafkaConfig.LogDirProp(), "logs/kafka-test");

		return new EmbeddedKafkaBroker(1, true, 2, topics).kafkaPorts(serverPort).brokerProperties(brokerProps);

	}

	@Bean
	public ProducerFactory<String, String> accountOpenedFactory() {

		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);

	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> kafkaProducerFactory) {

		KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(kafkaProducerFactory);
		return kafkaTemplate;

	}

}
