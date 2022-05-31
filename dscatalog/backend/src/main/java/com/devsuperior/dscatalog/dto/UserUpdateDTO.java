package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.services.validation.UserUpdateValid;

@UserUpdateValid//Annotation que vai processar por baixo dos panos se o e-mail inserido, já existe no banco de dados
public class UserUpdateDTO extends UserDTO{
	private static final long serialVersionUID = 1L;
	
	

}
