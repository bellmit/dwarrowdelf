package com.bankless.core.app.controller;

import com.bankless.core.app.command.SayHelloCmd;
import com.bankless.core.infrastructure.dto.SayHelloRequest;
import com.bankless.core.infrastructure.dto.SayHelloResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/command")
public class CommandController {

	private SayHelloCmd sayHelloCmd = new SayHelloCmd();

	@PostMapping("/sayHello")
	public ResponseEntity sayHello( @RequestBody SayHelloRequest request ) {
		SayHelloResponse response = sayHelloCmd.execute( request );
		return new ResponseEntity<SayHelloResponse>(response, HttpStatus.OK );
	}

}
