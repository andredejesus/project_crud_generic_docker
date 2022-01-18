package br.com.project.generic.service;

import java.io.Serializable;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ServiceGeneric<T, ID extends Serializable> {
	
	protected abstract JpaRepository<T, ID> repositoryGeneric();
	

	public List<T> findAll() {
		return this.repositoryGeneric().findAll();
	}
	

	public T save(T entity) {
		return this.repositoryGeneric().save(entity);
	}
	

	public T getById(ID id) {
		return this.repositoryGeneric().findById(id).get();
	}
	

	public void delete(ID id) {
		this.repositoryGeneric().deleteById(id);
	}
	

	public T update(T entity, ID id) {
		return this.repositoryGeneric().save(entity);
	}


}
