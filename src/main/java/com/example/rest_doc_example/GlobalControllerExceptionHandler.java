package com.example.rest_doc_example;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * NOTE: defining exception handler provides additional information in the doc
 * about response codes.
 */
@RestControllerAdvice
class GlobalControllerExceptionHandler
{
	@ExceptionHandler(ConversionFailedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorCodeResponse> handleConnversion(RuntimeException ex)
	{
		return new ResponseEntity<>(new ErrorCodeResponse("conversion_failed", ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CakeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorCodeResponse> handleBookNotFound(RuntimeException ex)
	{
		return new ResponseEntity<>(new ErrorCodeResponse("cake_not_found", ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	static class ErrorCodeResponse
	{
		private final String code;
		private final String message;

		public ErrorCodeResponse(String code, String message)
		{
			this.code = code;
			this.message = message;
		}

		public String getCode()
		{
			return code;
		}

		public String getMessage()
		{
			return message;
		}
	}
}
