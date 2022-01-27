package br.com.project.services;


import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.project.dtos.AuthDTO;
import br.com.project.enums.Roles;
import br.com.project.exception.UnauthorizedException;
import br.com.project.models.User;
import br.com.project.repositories.UserRepository;
import br.com.project.security.TokenAuthenticationService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * Servicos do Auth
 *
 */
@Slf4j
@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;

	public String user(HttpServletRequest request, HttpServletResponse response, AuthDTO authDTO)
			throws IOException, NotFoundException {
		log.debug("Login default start");
		Optional<User> op = verificaAutenticacao(authDTO);
		return makeAuthenication(request, response, op.get(), Roles.getRoleToTypeLogin(op.get().getTypeLogin()).name());
	}


	private Optional<User> verificaAutenticacao(AuthDTO authDTO) {
		log.debug("Verify auth");
		Optional<User> user = userRepository.findByUsername(authDTO.getUsername());
		if (!user.isPresent() || !authDTO.getPassword().equals(user.get().getPassword())) {
			log.debug("Info invalid to login");
			throw new UnauthorizedException("Dados inválidos");
		}
		return user;
	}

	private String makeAuthenication(HttpServletRequest request, HttpServletResponse response, User user, String roles)
			throws IOException {
		TokenAuthenticationService authenticationService = new TokenAuthenticationService();
		Boolean isAdm = roles.equals(Roles.ROLE_ADMIN.name());
		String userToken = authenticationService.addAuthentication(response, user, roles, isAdm);
		Authentication authentication = TokenAuthenticationService.getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return userToken;
	}

}
