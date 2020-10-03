package com.bankless.app.http.dto;

import com.bankless.domain.model.Account;
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
