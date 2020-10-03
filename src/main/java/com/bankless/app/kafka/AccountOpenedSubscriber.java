package com.bankless.app.kafka;

import com.bankless.app.kafka.dto.KafkaAccountOpenedEvent;
import com.bankless.app.kafka.dto.KafkaAccountOpenedValidator;
import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static io.vavr.API.*;

@Component
@Profile("local")
public class AccountOpenedSubscriber {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountOpenedSubscriber.class);

	@KafkaListener(topics = "${kafka.topic.account.opened}")
	public void listen(String data) {

		Either<String, KafkaAccountOpenedEvent> parseResult = parseEvent(data);
		if (parseResult.isRight()) {
			LOGGER.info("Processing event: " + parseResult.get().toString());
		}
		else {
			LOGGER.warn( String.format("Skipping event: '%s'. %s", data, parseResult.getLeft()) );
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