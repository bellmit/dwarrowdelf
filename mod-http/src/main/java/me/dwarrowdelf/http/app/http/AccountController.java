package me.dwarrowdelf.http.app.http;

import me.dwarrowdelf.http.app.http.dto.BaseResponse;
import me.dwarrowdelf.http.domain.model.Account;
import me.dwarrowdelf.http.domain.repository.AccountRepository;
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

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ResponseEntity findAccount(@RequestParam("no") Integer no) {

		Optional<Account> result = accountRepository.find(no);
		if (result.isPresent()) {
			BaseResponse response = new BaseResponse(LocalDateTime.now().toString(), result.get().toString());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		else {
			BaseResponse response = new BaseResponse(LocalDateTime.now().toString(), String.format("Account number %s not found", no));
			return new ResponseEntity<BaseResponse>(response, HttpStatus.NOT_FOUND);
		}

	}

}
