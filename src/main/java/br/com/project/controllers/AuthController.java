package br.com.project.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.dtos.AuthDTO;
import br.com.project.dtos.TokenDTO;
import br.com.project.exception.BusinessException;
import br.com.project.services.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;


@Api(tags = "Autenticação API")
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	/**
	 * Metodo responsavel pela geração do token
	 * 
	 * @param request
	 * @param response
	 * @param auth
	 * @return ResponseEntity<?>              
	 * @throws IOException
	 * @throws NotFoundException 
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(notes = "Geração de token de acesso", value = "Geração de token de acesso")
	public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response,
			@Validated @RequestBody AuthDTO auth) throws IOException, NotFoundException {
		String token = authService.user(request, response, auth);
		if (token == null) {
			throw new BusinessException("Dados invalidos");
		}
		return new ResponseEntity<>(TokenDTO.builder().token(token).build(), HttpStatus.OK);
	}
}
