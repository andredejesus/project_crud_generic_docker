package br.com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.project.generic.service.ServiceGeneric;
import br.com.project.models.UsuarioModel;
import br.com.project.repositories.UsuarioRepository;


@Service
public class UsuarioService extends ServiceGeneric<UsuarioModel, Long> {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected JpaRepository<UsuarioModel, Long> repositoryGeneric() {
		return usuarioRepository;
	}
	

}
