package br.com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.generic.controller.ControllerGeneric;
import br.com.project.generic.service.ServiceGeneric;
import br.com.project.models.UsuarioModel;
import br.com.project.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends ControllerGeneric<UsuarioModel, Long> {
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public ServiceGeneric<UsuarioModel, Long> serviceGeneric() {
		return usuarioService;
	}

}
