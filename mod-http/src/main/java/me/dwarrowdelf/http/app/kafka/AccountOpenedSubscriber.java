package me.dwarrowdelf.http.app.kafka;

import me.dwarrowdelf.http.app.kafka.dto.KafkaAccountOpenedEvent;
import me.dwarrowdelf.http.app.kafka.dto.KafkaAccountOpenedValidator;
import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class AccountOpenedSubscriber {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountOpenedSubscriber.class);

	@KafkaListener(topics = "${kafka.topic.account.opened}")
	public void subscribe(String data) {

		Either<String, KafkaAccountOpenedEvent> parseResult = parseEvent(data);
		if (parseResult.isRight()) {
			LOGGER.info("Processing event: " + parseResult.get().toString());
		}
		else {
			LOGGER.warn(String.format("Skipping event: '%s'. %s", data, parseResult.getLeft()));
		}

	}

	private Either<String, KafkaAccountOpenedEvent> parseEvent(String data) {

		Validation<Seq<String>, KafkaAccountOpenedEvent> result = KafkaAccountOpenedValidator
				.validateAccountOpenedEvent(data);

		if (result.isValid()) {
			return Either.right(result.get());
		}
		else {
			return Either.left(String.join(", ", result.getError()));
		}

	}

}