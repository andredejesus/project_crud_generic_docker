package br.com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.project.generic.service.ServiceGeneric;
import br.com.project.models.EmailModel;
import br.com.project.repositories.EmailRepository;

@Service
public class EmailService extends ServiceGeneric<EmailModel, Long> {
	
	@Autowired
	private EmailRepository emailRepository;

	@Override
	protected JpaRepository<EmailModel, Long> repositoryGeneric() {
		return emailRepository;
	}

}
