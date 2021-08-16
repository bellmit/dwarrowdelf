package me.dwarrowdelf.core.app.dto;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import me.dwarrowdelf.http.app.kafka.dto.KafkaAccountOpenedEvent;
import me.dwarrowdelf.http.app.kafka.dto.KafkaAccountOpenedValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("unit")
class KafkaAccountOpenedValidatorTest {

	@Test
	@DisplayName("Validator should reject an empty event")
	void emptyEvent() {

		Validation<Seq<String>, KafkaAccountOpenedEvent> result = KafkaAccountOpenedValidator
				.validateAccountOpenedEvent("");

		assertTrue(result.isInvalid());
		assertEquals(1, result.getError().size());
		result.getError().forEach(System.out::println);

	}

	@Test
	@DisplayName("Validator should report errors for all fields at once")
	void invalidEvent() {

		String plainEvent = "2020-50;COL;ac8100001;bal50000";
		Validation<Seq<String>, KafkaAccountOpenedEvent> result = KafkaAccountOpenedValidator
				.validateAccountOpenedEvent(plainEvent);

		assertTrue(result.isInvalid());
		assertEquals(4, result.getError().size());
		result.getError().forEach(System.out::println);

	}

	@Test
	@DisplayName("Validator should allow an event with valid values")
	void validEvent() {

		String plainEvent = "2020-10-02T14:25:00.458;USA;8100001;2800000";
		Validation<Seq<String>, KafkaAccountOpenedEvent> result = KafkaAccountOpenedValidator
				.validateAccountOpenedEvent(plainEvent);

		assertTrue(result.isValid());
		assertEquals("2020-10-02T14:25:00.458", result.get().getDateTime());
		assertEquals("USA", result.get().getCountryCode());
		assertEquals("8100001", result.get().getNo());
		assertEquals("2800000", result.get().getBalance());

	}

}