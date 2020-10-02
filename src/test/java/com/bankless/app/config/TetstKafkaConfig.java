package com.bankless.app.config;

import kafka.server.KafkaConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

import java.util.Collections;
import java.util.Map;

@Configuration
@Profile("test")
public class TetstKafkaConfig {

	@Value("${spring.kafka.server.port}")
	private int serverPort;

	@Value("${embedded.kafka.topics}")
	private String kafkaTopics;

	@Bean
	EmbeddedKafkaBroker embeddedKafkaBroker() {

		String[] topics = kafkaTopics.split("\\s*,\\s*");
		Map<String, String> brokerProps = Collections.singletonMap(KafkaConfig.LogDirProp(), "logs/kafka-test");

		return new EmbeddedKafkaBroker(1, true, 2, topics).kafkaPorts(serverPort).brokerProperties(brokerProps);
	}

}
