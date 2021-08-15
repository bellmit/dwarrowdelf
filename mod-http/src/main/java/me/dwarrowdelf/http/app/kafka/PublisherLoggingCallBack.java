package me.dwarrowdelf.http.app.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class PublisherLoggingCallBack<String> implements ListenableFutureCallback<SendResult<String, String>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublisherLoggingCallBack.class);

	@Override
	public void onFailure(Throwable ex) {
		LOGGER.error("Kafka publish failed", ex);
	}

	@Override
	public void onSuccess(SendResult<String, String> result) {

		RecordMetadata metadata = result.getRecordMetadata();

		java.lang.String message = java.lang.String.format(
				"Kafka event published successfully. topic: '%s' partition: '%s' offset '%s'", metadata.topic(),
				metadata.partition(), metadata.offset());

		LOGGER.info(message);

	}

}