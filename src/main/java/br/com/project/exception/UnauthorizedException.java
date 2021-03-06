package br.com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = -6181043547253874252L;

public UnauthorizedException(String message) {
    super(message);
 }
}
