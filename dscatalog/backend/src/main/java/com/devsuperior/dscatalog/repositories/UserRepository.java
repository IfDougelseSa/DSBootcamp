package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email); //Só com isso o repositório é capaz de buscar
	//no banco de dados os usuários passando o e-mail como argumento.
}
