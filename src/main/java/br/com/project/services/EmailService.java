package br.com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.project.generic.service.ServiceGeneric;
import br.com.project.models.Email;
import br.com.project.repositories.EmailRepository;

@Service
public class EmailService extends ServiceGeneric<Email, Long> {
	
	@Autowired
	private EmailRepository emailRepository;

	@Override
	protected JpaRepository<Email, Long> repositoryGeneric() {
		return emailRepository;
	}

}
