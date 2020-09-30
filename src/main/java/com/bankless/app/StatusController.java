package com.bankless.app;

import com.bankless.app.dto.ResponseDto;
import com.bankless.app.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class StatusController {

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity getStatus() {
		ResponseDto dto = new ResponseDto(LocalDateTime.now().toString(), "UP!");
		return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public ResponseEntity sayHello(@RequestBody UserDto request) {
		ResponseDto dto = new ResponseDto(LocalDateTime.now().toString(), "Hello " + request.getName());
		return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
	}

}
