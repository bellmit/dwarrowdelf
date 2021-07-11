package me.dwarrowdelf.app.http.exception;

import me.dwarrowdelf.app.http.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<BaseResponse> customException(Exception ex, WebRequest request) {

		BaseResponse dto = new BaseResponse(LocalDateTime.now().toString(), ex.getMessage());
		return new ResponseEntity<BaseResponse>(dto, HttpStatus.OK);

	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<BaseResponse> runtimeException(Exception ex, WebRequest request) {

		BaseResponse dto = new BaseResponse(LocalDateTime.now().toString(), ex.getMessage());
		return new ResponseEntity<BaseResponse>(dto, HttpStatus.OK);

	}

}
