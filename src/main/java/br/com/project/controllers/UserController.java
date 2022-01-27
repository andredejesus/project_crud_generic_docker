package br.com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.generic.controller.ControllerGeneric;
import br.com.project.generic.service.ServiceGeneric;
import br.com.project.models.User;
import br.com.project.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends ControllerGeneric<User, Long> {
	
	@Autowired
	private UserService userService;

	@Override
	public ServiceGeneric<User, Long> serviceGeneric() {
		return userService;
	}

}
