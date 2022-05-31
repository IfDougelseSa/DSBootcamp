package com.devsuperior.dscatalog.services.exceptions;


//Pode herdar de Exception(Obrigatoriamente tem que ser tradada
//e RunTimeException mais acessivel, podendo ou não tratar
public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super(msg);
	}

}
