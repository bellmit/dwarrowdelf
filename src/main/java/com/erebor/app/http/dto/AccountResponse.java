package com.erebor.app.http.dto;

import com.erebor.domain.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AccountResponse {

	private String dateTime;

	private Account account;

}
