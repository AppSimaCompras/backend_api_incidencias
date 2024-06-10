package com.lacomer.api.incidencias.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lacomer.api.incidencias.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

	
	//public List<Cliente> findByNombreContaining(String term);
	

	//public List<Cliente> findByEmailContaining(String term);
	

		@Query("SELECT c FROM Cliente c WHERE c.email = ?1")
		List<Cliente> findByEmail(String email);
	
}


