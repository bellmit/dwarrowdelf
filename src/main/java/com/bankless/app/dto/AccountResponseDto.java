package com.bankless.app.dto;

import com.bankless.domain.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AccountResponseDto {

	String dateTime;

	Account account;

}
