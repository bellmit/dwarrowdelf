package com.bankless.core.app.controller;

import com.bankless.core.infrastructure.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
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
