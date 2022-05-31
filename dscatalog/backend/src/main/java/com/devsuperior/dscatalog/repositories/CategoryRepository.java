package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Category;
/* Apenas com essa definição, já temos várias operações prontas para acessar os dados */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
/************************************************************************************/