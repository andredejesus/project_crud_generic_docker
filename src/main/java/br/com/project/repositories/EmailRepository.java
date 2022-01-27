package br.com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
