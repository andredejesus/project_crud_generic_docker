package br.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.models.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
