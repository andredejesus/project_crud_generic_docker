package br.com.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//@Query("select user from TBL_USER user where user.username = ?1")
	Optional<User> findByUsername(String username);

}
