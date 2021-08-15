package me.dwarrowdelf.http.app.http;

import me.dwarrowdelf.http.app.http.dto.BaseResponse;
import me.dwarrowdelf.http.app.http.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class StatusController {

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity getStatus() {
		BaseResponse dto = new BaseResponse(LocalDateTime.now().toString(), "UP!");
		return new ResponseEntity<BaseResponse>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public ResponseEntity sayHello(@RequestBody UserRequest request) {
		BaseResponse dto = new BaseResponse(LocalDateTime.now().toString(), "Hello " + request.getName());
		return new ResponseEntity<BaseResponse>(dto, HttpStatus.OK);
	}

}
