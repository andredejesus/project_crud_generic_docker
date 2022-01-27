package br.com.project.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Error {
	private String code;
	private String message;
}
