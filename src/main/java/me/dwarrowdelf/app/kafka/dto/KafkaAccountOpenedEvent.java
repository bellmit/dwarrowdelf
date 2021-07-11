package me.dwarrowdelf.app.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KafkaAccountOpenedEvent {

	private String dateTime;

	private String countryCode;

	private String no;

	private String balance;

	@Override
	public String toString() {
		return "KafkaAccountOpenedEvent{" + "dateTime='" + dateTime + '\'' + ", countryCode='" + countryCode + '\''
				+ ", no='" + no + '\'' + ", balance='" + balance + '\'' + '}';
	}

	public String toCsv() {
		return String.format("%s;%s;%s;%s", dateTime, countryCode, no, balance);
	}

}
