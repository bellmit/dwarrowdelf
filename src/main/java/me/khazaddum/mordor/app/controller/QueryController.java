package me.khazaddum.mordor.app.controller;

import java.util.concurrent.atomic.AtomicLong;
import me.khazaddum.mordor.domain.model.Greeting;
import me.khazaddum.mordor.infrastructure.dto.SayHelloRequest;
import me.khazaddum.mordor.infrastructure.dto.SayHelloResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueryController {

	@RequestMapping("/status")
	public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return "UP!";
	}

}
