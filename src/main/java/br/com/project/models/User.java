package br.com.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.project.enums.TypeLogin;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name="TBL_USER")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	private TypeLogin typeLogin;

}
