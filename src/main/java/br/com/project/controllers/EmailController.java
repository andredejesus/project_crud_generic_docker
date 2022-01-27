package br.com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.generic.controller.ControllerGeneric;
import br.com.project.generic.service.ServiceGeneric;
import br.com.project.models.Email;
import br.com.project.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController extends ControllerGeneric<Email, Long>{
	
	@Autowired
	private EmailService emailService;

	@Override
	public ServiceGeneric<Email, Long> serviceGeneric() {
		return emailService;
	}

}
