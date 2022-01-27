package br.com.project.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@JsonRootName(value="errors")
@Getter
@Setter
public class CustomErrors {
	
	private List<Error> errors;
}
