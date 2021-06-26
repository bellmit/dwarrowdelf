package com.erebor.app.kafka;

import com.erebor.app.kafka.dto.KafkaAccountOpenedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

public class AccountOpenedPublisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountOpenedPublisher.class);

	@Value("${kafka.topic.account.opened}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void publish(KafkaAccountOpenedEvent event) {

		String key = UUID.randomUUID().toString();
		String kafkaEvent = event.toCsv();

		LOGGER.info(String.format("Publishing event: topic '%s' key '%s' data %s", topic, key, kafkaEvent));

		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, key, kafkaEvent);
		result.addCallback(new PublisherLoggingCallBack());

	}

}