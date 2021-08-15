package me.dwarrowdelf.http.app.http.dto;

import me.dwarrowdelf.http.domain.model.Account;
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
