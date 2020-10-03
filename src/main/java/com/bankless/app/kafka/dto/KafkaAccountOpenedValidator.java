package com.bankless.app.kafka.dto;

import com.google.common.collect.ImmutableList;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;
import org.springframework.util.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static io.vavr.API.*;

public abstract class KafkaAccountOpenedValidator {

	private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

	private static final ImmutableList<String> countryCodes = ImmutableList.of("CAN", "USA");

	public static Validation<Seq<String>, KafkaAccountOpenedEvent> validateAccountOpenedEvent(String plainEvent) {

		String[] fields = plainEvent.split(";");
		if (fields.length != 4) {
			String error = String.format(
					"Invalid number of fields separated with semicolon ';' expected 4, received %s", fields.length);
			return Validation.invalid(Seq(error));
		}
		else {
			return Validation.combine(validateDateTime(dateFormat, fields[0]),
					validateCountryCode(countryCodes, fields[1]), validateNumber(fields[2]), validateBalance(fields[3]))
					.ap(KafkaAccountOpenedEvent::new);
		}
	}

	private static Validation<String, String> validateDateTime(SimpleDateFormat dateFormat, String rawDate) {
		try {
			dateFormat.parse(rawDate);
			return Validation.valid(rawDate);
		}
		catch (ParseException ex) {
			return Validation
					.invalid(String.format("DateTime '%s' cannot be parsed to format %s", rawDate, DATE_PATTERN));
		}
	}

	private static Validation<String, String> validateCountryCode(ImmutableList<String> countryCodes, String code) {
		if (countryCodes.contains(code)) {
			return Validation.valid(code);
		}
		else {
			return Validation.invalid(String.format("Invalid country code '%s'. Expected one of: '%s'", code,
					String.join(",", countryCodes)));
		}
	}

	private static Validation<String, String> validateNumber(String no) {
		try {
			Integer.parseInt(no);
			return Validation.valid(no);
		}
		catch (NumberFormatException ex) {
			return Validation.invalid(String.format("Account number '%s' contains invalid characters", no));
		}
	}

	private static Validation<String, String> validateBalance(String balance) {
		try {
			Double.parseDouble(balance);
			return Validation.valid(balance);
		}
		catch (NumberFormatException ex) {
			return Validation.invalid(String.format("Balance '%s' contains invalid characters", balance));
		}
	}

}
