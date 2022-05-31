package com.devsuperior.dscatalog.services.exceptions;


//Pode herdar de Exception(Obrigatoriamente tem que ser tradada
//e RunTimeException mais acessivel, podendo ou não tratar
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
