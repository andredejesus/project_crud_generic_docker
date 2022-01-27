package br.com.project.generic.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.project.generic.service.ServiceGeneric;
import io.swagger.annotations.ApiOperation;

public abstract class ControllerGeneric<T, ID extends Serializable> {
	
	public abstract ServiceGeneric<T, ID> serviceGeneric();
	
	@PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_ADMIN')")
	@ApiOperation(value = "Recupera uma lista de entidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T>> findAll(){
		return ResponseEntity.ok(this.serviceGeneric().findAll());
	}
	
	@PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_ADMIN')")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Salva uma entidade")
	public ResponseEntity<T> save(@RequestBody T entity){
		return ResponseEntity.ok(this.serviceGeneric().save(entity));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_ADMIN')")
	@ApiOperation(value = "Recupera uma entidade pelo ID")
	@GetMapping(value="{id}")
	public ResponseEntity<T> getById(@PathVariable(name="id") ID id){
		return ResponseEntity.ok(this.serviceGeneric().getById(id));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_ADMIN')")
	@ApiOperation(value = "Editar uma entidade pelo ID")
	@PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<T> update(@RequestBody T entity, @PathVariable ID id){
		return ResponseEntity.ok(this.serviceGeneric().update(entity, id));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_ADMIN')")
	@ApiOperation(value = "deleta uma entidade pelo ID")
	@DeleteMapping("{id}")
	public ResponseEntity<T> delete(@PathVariable ID id){
		this.serviceGeneric().delete(id);
		return ResponseEntity.ok().build();
	}

}
