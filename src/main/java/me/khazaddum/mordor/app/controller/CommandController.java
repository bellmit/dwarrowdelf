package me.khazaddum.mordor.app.controller;

import me.khazaddum.mordor.app.command.SayHelloCmd;
import me.khazaddum.mordor.infrastructure.dto.SayHelloRequest;
import me.khazaddum.mordor.infrastructure.dto.SayHelloResponse;
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
