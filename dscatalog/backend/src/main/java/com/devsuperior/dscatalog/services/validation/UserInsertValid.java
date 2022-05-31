package com.devsuperior.dscatalog.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/*
 * Pela validação ser uma regra de negócios e mexar com o banco de dados
 * ela é criada na camada de serviços
 * Codigo boilerplate padrão, sendo "não necessario entender", apenas se quiser 
 * se especializar
 */


@Constraint(validatedBy = UserInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface UserInsertValid {
	String message() default "Validation error";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}