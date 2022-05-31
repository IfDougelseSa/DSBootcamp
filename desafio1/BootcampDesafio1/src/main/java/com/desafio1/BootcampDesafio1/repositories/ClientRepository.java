package com.desafio1.BootcampDesafio1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio1.BootcampDesafio1.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
