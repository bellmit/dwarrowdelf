package com.bankless.app;

import com.bankless.app.dto.ResponseDto;
import com.bankless.app.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	@RequestMapping("/status")
	public ResponseEntity getStatus() {
		ResponseDto dto = new ResponseDto("UP!");
		return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
	}

	@PostMapping("/greeting")
	public ResponseEntity sayHello(@RequestBody UserDto request) {
		ResponseDto dto = new ResponseDto("Hello " + request.getName());
		return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
	}

}
