package com.bankless.app;

import com.bankless.app.dto.AccountResponseDto;
import com.bankless.app.dto.ResponseDto;
import com.bankless.app.dto.UserDto;
import com.bankless.domain.model.Account;
import com.bankless.domain.repository.AccountRepository;
import com.bankless.infrastructure.repository.AccountRepositoryInCassandra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = "{country}/account", method = RequestMethod.GET)
	public ResponseEntity findAccount(@PathVariable(name = "country") String countryCode,
			@RequestParam("no") int accountNo) {

		Optional<Account> result = accountRepository.find(countryCode, accountNo);
		if (result.isPresent()) {
			AccountResponseDto dto = new AccountResponseDto(LocalDateTime.now().toString(), result.get());
			return new ResponseEntity<AccountResponseDto>(dto, HttpStatus.OK);
		}
		else {
			ResponseDto dto = new ResponseDto(LocalDateTime.now().toString(),
					String.format("Account number %s for country code %s not found", accountNo, countryCode));
			return new ResponseEntity<ResponseDto>(dto, HttpStatus.NOT_FOUND);
		}

	}

}
