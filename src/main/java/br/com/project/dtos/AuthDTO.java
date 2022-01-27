package br.com.project.dtos;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa os dados de login do usuario 
 * @author erick.oliveira
 *
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {
	
	@NotEmpty(message = "username não informado")
	private String username;
	
	@NotEmpty(message = "password não informado")
	private String password;

}
