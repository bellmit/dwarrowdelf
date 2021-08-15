package me.dwarrowdelf.http.app.http.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BaseResponse {

	private String dateTime;

	private String message;

}
