package br.com.project.generic.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.project.generic.service.ServiceGeneric;

public abstract class ControllerGeneric<T, ID extends Serializable> {
	
	public abstract ServiceGeneric<T, ID> serviceGeneric();
	
	@GetMapping
	public ResponseEntity<List<T>> findAll(){
		return ResponseEntity.ok(this.serviceGeneric().findAll());
	}
	
	@PostMapping
	public ResponseEntity<T> save(@RequestBody T entity){
		return ResponseEntity.ok(this.serviceGeneric().save(entity));
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<T> getById(@PathVariable(name="id") ID id){
		return ResponseEntity.ok(this.serviceGeneric().getById(id));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<T> update(@RequestBody T entity, @PathVariable ID id){
		return ResponseEntity.ok(this.serviceGeneric().update(entity, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<T> delete(@PathVariable ID id){
		this.serviceGeneric().delete(id);
		return ResponseEntity.ok().build();
	}

}
