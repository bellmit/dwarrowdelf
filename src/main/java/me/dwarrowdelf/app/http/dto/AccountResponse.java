package me.dwarrowdelf.app.http.dto;

import me.dwarrowdelf.domain.model.Account;
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
