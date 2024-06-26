package com.lacomer.api.incidencias.models.services;


import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacomer.api.incidencias.models.entity.Cliente;


public interface IClienteService {

	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public List<Cliente> findClienteByEmail(String term);
	

	
}
