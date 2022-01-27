package br.com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = -1366147018671437239L;

public BadRequestException(String message) {
    super(message);
 }
}
