package br.com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.project.generic.service.ServiceGeneric;
import br.com.project.models.User;
import br.com.project.repositories.UserRepository;


@Service
public class UserService extends ServiceGeneric<User, Long> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	protected JpaRepository<User, Long> repositoryGeneric() {
		return userRepository;
	}
	

}
