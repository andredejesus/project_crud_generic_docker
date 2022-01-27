package br.com.project.exception;

import java.util.List;

public class BusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3946464700594703017L;
	
	List<Error> erros;
	
	public BusinessException() {
	    super();
	 }
	public BusinessException(String msg) {
	    super(msg);
	 }
	public BusinessException(List<Error> erros) {
	    super();
		this.erros = erros;
	 }
	public List<Error> getErros() {
		return erros;
	}
	public void setErros(List<Error> erros) {
		this.erros = erros;
	}
	
	
	
	
}
