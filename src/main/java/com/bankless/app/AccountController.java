package com.bankless.app;

import com.bankless.app.dto.AccountResponseDto;
import com.bankless.app.dto.ResponseDto;
import com.bankless.app.dto.UserDto;
import com.bankless.domain.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class AccountController {

	@RequestMapping(value = "{country}/account", method = RequestMethod.GET)
	public ResponseEntity findAccount( @PathVariable(name = "country") String countryCode, @RequestParam("no") int accountNo) {

		Account account = new Account( countryCode, accountNo, 10000);
		AccountResponseDto dto = new AccountResponseDto(LocalDateTime.now().toString(), account);

		return new ResponseEntity<AccountResponseDto>(dto, HttpStatus.OK);

	}

}
