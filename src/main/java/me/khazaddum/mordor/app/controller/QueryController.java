package me.khazaddum.mordor.app.controller;

import java.util.concurrent.atomic.AtomicLong;
import me.khazaddum.mordor.domain.model.Greeting;
import me.khazaddum.mordor.infrastructure.dto.SayHelloRequest;
import me.khazaddum.mordor.infrastructure.dto.SayHelloResponse;
import me.khazaddum.mordor.infrastructure.service.EventService;
import me.khazaddum.mordor.infrastructure.service.impl.EventServiceConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueryController {

	@Autowired
	private EventService eventService;

	@RequestMapping("/status")
	public String status() {
		String msg = "status UP!";
		String result = eventService.publish( msg );
		return "UP!";
	}

}
